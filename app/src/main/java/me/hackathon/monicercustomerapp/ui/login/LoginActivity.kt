package me.hackathon.monicercustomerapp.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import me.hackathon.monicercustomerapp.BuildConfig
import me.hackathon.monicercustomerapp.R
import me.hackathon.monicercustomerapp.databinding.ActivityLoginBinding
import me.hackathon.monicercustomerapp.ui.main.MainActivity
import me.hackathon.monicercustomerapp.util.CustomViewModelFactory
import me.hackathon.monicercustomerapp.util.hideKeyboard
import javax.inject.Inject
import com.pusher.client.channel.SubscriptionEventListener
import com.pusher.client.Pusher
import com.pusher.client.PusherOptions
import org.jetbrains.anko.alert
import org.jetbrains.anko.cancelButton
import org.jetbrains.anko.noButton

class LoginActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: CustomViewModelFactory
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
        binding.viewModel = viewModel

        @Suppress("ConstantConditionIf")
        if (BuildConfig.BUILD_TYPE == "debug") {
            viewModel.email.set(resources.getString(R.string.test_username))
            viewModel.password.set(resources.getString(R.string.test_password))
        }

        val hideKeyboardListener =
                View.OnFocusChangeListener { v, hasFocus ->
                    if (!hasFocus && !login_password_edit.hasFocus() && !login_email_edit.hasFocus()) {
                        v.hideKeyboard()
                    }
                }

        login_email_edit.onFocusChangeListener = hideKeyboardListener
        login_password_edit.onFocusChangeListener = hideKeyboardListener
        login_password_edit.setOnEditorActionListener { _, actionId, _ ->
            var handled = false
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if (login_button.isEnabled) login_button.performClick()
                handled = true
            }
            handled
        }

        login_button.setOnClickListener { loginButton ->
            loginButton.isEnabled = false
            viewModel.authenticate().observe(this, Observer { authResponse ->
                if (authResponse.isSuccessful) {
                    viewModel.initUser(authResponse.body!!)
                    startActivity(Intent(this, MainActivity::class.java))
                    supportFinishAfterTransition()
                } else Snackbar.make(login_root, authResponse.errorMessage, Snackbar.LENGTH_LONG)
            })
        }
    }
}
