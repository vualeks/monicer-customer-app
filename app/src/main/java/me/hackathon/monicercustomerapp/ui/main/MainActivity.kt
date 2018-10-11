package me.hackathon.monicercustomerapp.ui.main

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import me.hackathon.monicercustomerapp.R

class MainActivity : DaggerAppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

  }
}
