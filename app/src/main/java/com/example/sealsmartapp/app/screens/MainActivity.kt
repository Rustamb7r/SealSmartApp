package com.example.sealsmartapp.app.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sealsmartapp.R
import com.example.sealsmartapp.app.Navigator
import com.example.sealsmartapp.databinding.ActivityMainBinding
import com.example.sealsmartapp.domain.entities.AccountModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), Navigator {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView, FirstFragment.newInstance())
            .commit()
    }


    override fun showSecondFragment(accountModel: AccountModel,viewModel: FirstViewModel) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentContainerView, SecondFragment.newInstance(accountModel).apply {
                onDismissListener = {
                    viewModel.postValueAccount(it)
                }
            })
            .commit()
    }

    override fun showThirdFragment() {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentContainerView, ThirdFragment.newInstance())
            .commit()
    }
}