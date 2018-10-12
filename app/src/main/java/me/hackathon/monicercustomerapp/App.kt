package me.hackathon.monicercustomerapp

import android.util.Log
import com.pusher.client.Pusher
import com.pusher.client.PusherOptions
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import me.hackathon.monicercustomerapp.di.DaggerAppComponent

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        val options = PusherOptions()

        options.setCluster("eu")
        pusher = Pusher("6fcb08bc663efe24136f", options)

        pusher.connect()
    }

    override fun applicationInjector(): AndroidInjector<out App> {
        return DaggerAppComponent.builder().application(this@App).build()
    }

    companion object {
        lateinit var pusher: Pusher
    }
}