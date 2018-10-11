package me.hackathon.monicercustomerapp

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import me.hackathon.monicercustomerapp.di.DaggerAppComponent

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out App> {
        return DaggerAppComponent.builder().application(this@App).build()
    }
}