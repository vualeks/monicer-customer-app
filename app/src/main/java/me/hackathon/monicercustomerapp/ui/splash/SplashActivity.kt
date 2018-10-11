package me.hackathon.monicercustomerapp.ui.splash

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import me.hackathon.monicercustomerapp.R

class SplashActivity : DaggerAppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)
  }
}
