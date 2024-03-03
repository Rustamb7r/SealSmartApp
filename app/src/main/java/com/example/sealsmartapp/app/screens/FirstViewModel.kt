package com.example.sealsmartapp.app.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sealsmartapp.domain.Interactor.FirstInteractor
import com.example.sealsmartapp.domain.entities.AccountModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val firstInteractor: FirstInteractor
) : ViewModel() {

    private val _liveData = MutableLiveData<String>()
    val liveData: LiveData<String> = _liveData

    private val _liveData2 = MutableLiveData<AccountModel>()
    val liveData2: LiveData<AccountModel> = _liveData2

    private val _liveDataAccount = MutableLiveData<String>()
    val liveDataAccount: LiveData<String> = _liveDataAccount


    fun zaprosToken() = viewModelScope.launch {
        _liveData.postValue(firstInteractor.getToken())
    }

    fun zaprosAccount() = viewModelScope.launch {
        _liveData2.postValue(firstInteractor.getAccount())
    }

    fun postValueAccount(it: String) {
        _liveDataAccount.postValue(it)

    }
}

