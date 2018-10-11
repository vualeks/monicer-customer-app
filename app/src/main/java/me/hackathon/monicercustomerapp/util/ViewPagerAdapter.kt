package me.hackathon.monicercustomerapp.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.ArrayList

class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
  override fun getCount(): Int {
    return mFragmentList.size
  }

  private val mFragmentList = ArrayList<Fragment>()

  override fun getItem(position: Int): Fragment {
    return mFragmentList[position]
  }

  fun addFragment(fragment: Fragment) {
    mFragmentList.add(fragment)
  }
}