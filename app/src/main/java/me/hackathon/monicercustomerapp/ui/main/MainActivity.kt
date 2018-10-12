package me.hackathon.monicercustomerapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.google.gson.Gson
import com.pusher.client.Pusher
import com.pusher.client.channel.Channel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.hackathon.monicercustomerapp.App
import me.hackathon.monicercustomerapp.App.Companion
import me.hackathon.monicercustomerapp.R
import me.hackathon.monicercustomerapp.ui.main.payment.PaymentFragment
import me.hackathon.monicercustomerapp.ui.main.profile.ProfileFragment
import me.hackathon.monicercustomerapp.ui.main.shops.ShopsFragment
import me.hackathon.monicercustomerapp.ui.main.wallet.WalletFragment
import me.hackathon.monicercustomerapp.util.Constants
import me.hackathon.monicercustomerapp.util.Constants.CURRENT_USER
import me.hackathon.monicercustomerapp.util.CustomViewModelFactory
import me.hackathon.monicercustomerapp.util.ViewPagerAdapter
import me.hackathon.monicercustomerapp.vo.PaymentConfirmationEvent
import org.jetbrains.anko.alert
import org.jetbrains.anko.cancelButton
import org.jetbrains.anko.noButton
import org.jetbrains.anko.okButton
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), ViewPager.OnPageChangeListener {

  @Inject
  lateinit var viewModelFactory: CustomViewModelFactory
  lateinit var viewModel: MainActivityViewModel
  private lateinit var adapter: ViewPagerAdapter
  lateinit var channel: Channel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    initViewPager()
    initBottomNavigationView()

    channel = App.pusher.subscribe("test")
  }

  override fun onResume() {
    super.onResume()

    channel.bind("payment.confirmation") { channelName, eventName, data ->
      val transactionConfirmation =
        Gson().fromJson<PaymentConfirmationEvent>(data, PaymentConfirmationEvent::class.java)
      Constants.payCodeLiveData.postValue(transactionConfirmation.newPayCode)
      CURRENT_USER.payCode = transactionConfirmation.newPayCode

      runOnUiThread {
        alert("Payment completed. Your cashback is " + transactionConfirmation.returnedAmount) {
          title = "Payment completed"
          okButton { }
        }.show()
      }
    }
  }

  override fun onPause() {
    super.onPause()

    //TODO unbind channel
  }

  private fun initBottomNavigationView() {}

  private fun initViewPager() {
    adapter = ViewPagerAdapter(supportFragmentManager)
    adapter.addFragment(PaymentFragment())
    adapter.addFragment(WalletFragment())
    adapter.addFragment(ShopsFragment())
    adapter.addFragment(ProfileFragment())

    view_pager.offscreenPageLimit = 4
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
