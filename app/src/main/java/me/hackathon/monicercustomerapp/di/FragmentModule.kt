package me.hackathon.monicercustomerapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.hackathon.monicercustomerapp.ui.main.payment.PaymentFragment
import me.hackathon.monicercustomerapp.ui.main.profile.ProfileFragment
import me.hackathon.monicercustomerapp.ui.main.shops.ShopsFragment
import me.hackathon.monicercustomerapp.ui.main.wallet.WalletFragment

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun bindPaymentFragment(): PaymentFragment

    @ContributesAndroidInjector
    abstract fun bindWalletFragment(): WalletFragment

    @ContributesAndroidInjector
    abstract fun bindShopsFragment(): ShopsFragment

    @ContributesAndroidInjector
    abstract fun bindProfileFragment(): ProfileFragment
}