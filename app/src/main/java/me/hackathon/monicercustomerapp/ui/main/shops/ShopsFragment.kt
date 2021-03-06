package me.hackathon.monicercustomerapp.ui.main.shops

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import me.hackathon.monicercustomerapp.R
import me.hackathon.monicercustomerapp.util.CustomViewModelFactory
import javax.inject.Inject

class ShopsFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: CustomViewModelFactory
    private lateinit var viewModel: ShopsFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_shops, container, false)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ShopsFragmentViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
    }
}