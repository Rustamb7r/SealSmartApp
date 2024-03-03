package com.example.sealsmartapp.app

import com.example.sealsmartapp.app.screens.FirstViewModel
import com.example.sealsmartapp.domain.entities.AccountModel

interface Navigator {

    fun showSecondFragment(account: AccountModel,viewModel: FirstViewModel)

    fun showThirdFragment()
}
