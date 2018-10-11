package me.hackathon.monicercustomerapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.hackathon.monicercustomerapp.ui.main.payment.PaymentFragment
import me.hackathon.monicercustomerapp.ui.main.payment.pay.PayFragment
import me.hackathon.monicercustomerapp.ui.main.payment.split.SplitFragment
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

    @ContributesAndroidInjector
    abstract fun bindPayFragment(): PayFragment

    @ContributesAndroidInjector
    abstract fun bindSplitFragment(): SplitFragment
}