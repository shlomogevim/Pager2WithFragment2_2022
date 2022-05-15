package com.sg.pager2withfragment2_2022

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var infiniteViewPager: ViewPager2
    private lateinit var infiniteRecyclerAdapter: InfiniteRecyclerAdapter

    private var sampleList: MutableList<Sample> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getting the required sample data for filling the ViewPager
        getSampleData()

        // setting up the infinite ViewPager
        infiniteViewPager = findViewById(R.id.infinted_viewPager)
        infiniteRecyclerAdapter = InfiniteRecyclerAdapter(sampleList)
        infiniteViewPager.adapter = infiniteRecyclerAdapter

        // setting the current item of the infinite ViewPager to the actual first element
        infiniteViewPager.currentItem = 1

        // function for registering a callback to update the ViewPager
        // and provide a smooth flow for infinite scroll
        onInfinitePageChangeCallback(sampleList.size + 2)
    }

    private fun getSampleData() {
        sampleList.add(Sample(1, "#91C555"))
        sampleList.add(Sample(2, "#F48E37"))
        sampleList.add(Sample(3, "#FF7B7B"))
    }

    private fun onInfinitePageChangeCallback(listSize: Int) {
        infiniteViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)

                if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    when (infiniteViewPager.currentItem) {
                        listSize - 1 -> infiniteViewPager.setCurrentItem(1, false)
                        0 -> infiniteViewPager.setCurrentItem(listSize - 2, false)
                    }
                }
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if (position != 0 && position != listSize - 1) {
                    // pageIndicatorView.setSelected(position-1)
                }
            }
        })
    }

}







  /*  private lateinit var tabLayout:TabLayout
    private lateinit var viewPager:ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout=findViewById(R.id.tabLayout)
        viewPager=findViewById(R.id.viewPager)
        viewPager.adapter=PagerAdapter(this)
        TabLayoutMediator(tabLayout,viewPager){tab,index ->
            tab.text=when (index){
                0 -> {"First"}
                1 -> {"Second"}
                2 -> {"Third"}
                else -> {throw Resources.NotFoundException("Position not found")}
            }
        }.attach()

    }
}*/