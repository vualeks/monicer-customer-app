package me.hackathon.monicercustomerapp.ui.main

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.hackathon.monicercustomerapp.R
import me.hackathon.monicercustomerapp.ui.main.payment.PaymentFragment
import me.hackathon.monicercustomerapp.ui.main.profile.ProfileFragment
import me.hackathon.monicercustomerapp.ui.main.shops.ShopsFragment
import me.hackathon.monicercustomerapp.ui.main.wallet.WalletFragment
import me.hackathon.monicercustomerapp.util.CustomViewModelFactory
import me.hackathon.monicercustomerapp.util.ViewPagerAdapter
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), ViewPager.OnPageChangeListener {

    @Inject
    lateinit var viewModelFactory: CustomViewModelFactory
    lateinit var viewModel: MainActivityViewModel
    private lateinit var adapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewPager()
        initBottomNavigationView()
    }

    private fun initBottomNavigationView() {}

    private fun initViewPager() {
        adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(PaymentFragment())
        adapter.addFragment(WalletFragment())
        adapter.addFragment(ShopsFragment())
        adapter.addFragment(ProfileFragment())

        view_pager.adapter = adapter
        view_pager.addOnPageChangeListener(this)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_pay -> setCurrentItem(0)
                R.id.action_wallet -> setCurrentItem(1)
                R.id.action_shops -> setCurrentItem(2)
                R.id.action_profile -> setCurrentItem(3)
                else -> false
            }
        }
    }

    private fun setCurrentItem(position: Int): Boolean {
        view_pager.currentItem = position
        return true
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
    ) {
    }

    override fun onPageSelected(position: Int) {}
}
