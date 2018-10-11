package me.hackathon.monicercustomerapp.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import me.hackathon.monicercustomerapp.ui.login.LoginViewModel
import me.hackathon.monicercustomerapp.ui.main.MainViewModel
import me.hackathon.monicercustomerapp.ui.main.payment.PaymentFragmentViewModel
import me.hackathon.monicercustomerapp.ui.main.profile.ProfileFragmentViewModel
import me.hackathon.monicercustomerapp.ui.main.shops.ShopsFragmentViewModel
import me.hackathon.monicercustomerapp.ui.main.wallet.WalletFragmentViewModel
import kotlin.reflect.KClass

@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(editProfileViewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PaymentFragmentViewModel::class)
    abstract fun bindPaymentFragmentViewModel(paymentFragmentViewModel: PaymentFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WalletFragmentViewModel::class)
    abstract fun bindWalletFragmentViewModel(walletFragmentViewModel: WalletFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShopsFragmentViewModel::class)
    abstract fun bindShopsFragmentViewModel(shopsFragmentViewModel: ShopsFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileFragmentViewModel::class)
    abstract fun bindProfileFragmentViewModel(profileFragmentViewModel: ProfileFragmentViewModel): ViewModel
}