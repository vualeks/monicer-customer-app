package me.hackathon.monicercustomerapp.ui.splash

import android.content.Intent
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import me.hackathon.monicercustomerapp.R
import me.hackathon.monicercustomerapp.ui.login.LoginActivity

class SplashActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startActivity(Intent(this, LoginActivity::class.java))
        supportFinishAfterTransition()
    }
}
