package com.example.myapplication.activity

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.R
import com.example.myapplication.adapter.*
import com.example.myapplication.model.FeaturedProductModel
import com.example.myapplication.model.HomeProductModel
import com.example.myapplication.model.LatestProductModel
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class MainActivity : AppCompatActivity(),View.OnClickListener{

    private lateinit var viewpager : ViewPager
    private lateinit var dotsIndicator : DotsIndicator
    private lateinit var recyclerView: RecyclerView
    private lateinit var linerLayoutManager: LinearLayoutManager
    private lateinit var latestRecyclerView: RecyclerView
    private lateinit var homeRecyclerView: RecyclerView
    private lateinit var featuredRecyclerView: RecyclerView

    //dummy data
    private val bannerList =  arrayListOf(
        R.drawable.banner1,
        R.drawable.banner2,
        R.drawable.banner3,
        R.drawable.banner1,
        R.drawable.banner2,
        R.drawable.banner3
    )
    private val imagesList =  arrayListOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3
    )
    private val latestProductList =  arrayListOf(
        LatestProductModel("Westclo1", "Solid Men Polo Neck Dark Blue T-Shirt1", 199F),
        LatestProductModel("Westclo2", "Solid Men Polo Neck Dark Blue T-Shirt2", 299F),
        LatestProductModel("Westclo3", "Solid Men Polo Neck Dark Blue T-Shirt3", 399F),
        LatestProductModel("Westclo4", "Solid Men Polo Neck Dark Blue T-Shirt4", 499F),
        LatestProductModel("Westclo5", "Solid Men Polo Neck Dark Blue T-Shirt5", 599F),
        LatestProductModel("Westclo6", "Solid Men Polo Neck Dark Blue T-Shirt6", 699F),
        LatestProductModel("Westclo7", "Solid Men Polo Neck Dark Blue T-Shirt7", 799F)
    )
    private val homeProductList = arrayListOf(
        HomeProductModel("Wall Stikers1","Best Selling1","Wall Stickers1"),
        HomeProductModel("Wall Stikers2","Best Selling2","Wall Stickers2"),
        HomeProductModel("Wall Stikers3","Best Selling3","Wall Stickers3"),
        HomeProductModel("Wall Stikers4","Best Selling4","Wall Stickers4"),
        HomeProductModel("Wall Stikers5","Best Selling5","Wall Stickers5"),
        HomeProductModel("Wall Stikers6","Best Selling6","Wall Stickers6"),
        HomeProductModel("Wall Stikers7","Best Selling7","Wall Stickers7")
    )
    private val featuredProductList = arrayListOf(
        FeaturedProductModel("Nikey1","Nike Men's Air Behold Low Basketball Shoes1",10,1000F,900F,false,false),
        FeaturedProductModel("Nikey2","Nike Men's Air Behold Low Basketball Shoes2",20,1000F,800F,true,true),
        FeaturedProductModel("Nikey3","Nike Men's Air Behold Low Basketball Shoes3",30,1000F,700F,true,false),
        FeaturedProductModel("Nikey4","Nike Men's Air Behold Low Basketball Shoes4",40,1000F,600F,false,true),
        FeaturedProductModel("Nikey5","Nike Men's Air Behold Low Basketball Shoes5",50,1000F,500F,true,false),
        FeaturedProductModel("Nikey6","Nike Men's Air Behold Low Basketball Shoes6",60,1000F,400F,true,true),
        FeaturedProductModel("Nikey7","Nike Men's Air Behold Low Basketball Shoes7",70,1000F,300F,false,false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        //banner
        viewpager = findViewById(R.id.viewpager)
        dotsIndicator = findViewById(R.id.dots_indicator)
        val adapter = BannerAdapter(this,bannerList)
        viewpager.adapter = adapter
        dotsIndicator.setViewPager(viewpager)

        //images
        recyclerView = findViewById(R.id.recyclerView)
        linerLayoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)
        recyclerView.layoutManager = linerLayoutManager
        val imageAdapter = ImageAdapter(imagesList)
        recyclerView.adapter = imageAdapter
        val left = findViewById<ImageView>(R.id.left)
        val right = findViewById<ImageView>(R.id.right)
        left.setOnClickListener(this)
        right.setOnClickListener(this)

        //latest products
        latestRecyclerView = findViewById(R.id.latestRecyclerView)
        latestRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)
        val latestAdapter = LatestProductsAdapter(latestProductList)
        latestRecyclerView.adapter = latestAdapter

        //home products
        homeRecyclerView = findViewById(R.id.homeRecyclerView)
        homeRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)
        val homeAdapter = HomeProductsAdapter(homeProductList)
        homeRecyclerView.adapter = homeAdapter

        //featured products
        featuredRecyclerView = findViewById(R.id.featuredRecyclerView)
        featuredRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)
        val featuredAdapter = FeaturedProductAdapter(featuredProductList)
        featuredRecyclerView.adapter = featuredAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
    override fun onClick(v: View ) {
        when (v.id) {
            R.id.left ->{
                if(linerLayoutManager.findFirstCompletelyVisibleItemPosition()!=0)
                recyclerView.smoothScrollToPosition(linerLayoutManager.findFirstCompletelyVisibleItemPosition() - 1)
            }
            R.id.right ->{
                if(linerLayoutManager.findLastCompletelyVisibleItemPosition()!=(imagesList.size-1))
                recyclerView.smoothScrollToPosition(linerLayoutManager.findLastCompletelyVisibleItemPosition() + 1)

            }
        }
    }
}
