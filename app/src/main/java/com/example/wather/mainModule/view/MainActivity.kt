package com.example.wather.mainModule.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.wather.BR
import com.example.wather.R
import com.example.wather.databinding.ActivityMainBinding
import com.example.wather.mainModule.viewModel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        setUpViewModel()
        setUpObserber()
    }

    private fun setUpObserber() {
        mBinding.viewModel?.let { it.getSnackBarMessage().observe(this){ resMessage ->
            Snackbar.make(mBinding.root, resMessage, Snackbar.LENGTH_LONG).show()
        } }
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch{
            mBinding.viewModel?.getWatherAndForCast(21.973082,-102.267586, "4a90d4d87b7c16f1ca989d1c31c6cede", "metric", "es")
        }
    }

    private fun setUpViewModel() {
        val mainViewModel: MainViewModel by viewModels()
        mBinding.lifecycleOwner = this
        mBinding.setVariable(BR.viewModel, mainViewModel)

    }
}