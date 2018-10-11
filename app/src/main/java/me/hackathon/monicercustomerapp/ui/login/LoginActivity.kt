package me.hackathon.monicercustomerapp.ui.login

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import me.hackathon.monicercustomerapp.BuildConfig
import me.hackathon.monicercustomerapp.R
import me.hackathon.monicercustomerapp.util.CustomViewModelFactory
import me.hackathon.monicercustomerapp.util.hideKeyboard
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: CustomViewModelFactory
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)

        @Suppress("ConstantConditionIf")
        if (BuildConfig.BUILD_TYPE == "debug") {
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
    }
}
