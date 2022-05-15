package com.sg.pager2withfragment2_2022

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount()=3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->FirstFragment()
            1->SecondFragment()
            2->ThirdFragment()
//            else->FirstFragment()
            else-> {throw Resources.NotFoundException("Position not Found Mr.")}
        }
    }
}