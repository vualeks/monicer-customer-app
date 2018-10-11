package me.hackathon.monicercustomerapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.hackathon.monicercustomerapp.ui.login.LoginActivity
import me.hackathon.monicercustomerapp.ui.main.MainActivity
import me.hackathon.monicercustomerapp.ui.scan.ScanActivity
import me.hackathon.monicercustomerapp.ui.splash.SplashActivity

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindScanActivity(): ScanActivity
}