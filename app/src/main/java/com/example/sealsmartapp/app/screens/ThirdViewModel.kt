package com.example.sealsmartapp.app.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sealsmartapp.domain.Interactor.FirstInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThirdViewModel @Inject constructor(
    private val firstInteractor: FirstInteractor
) : ViewModel() {

    private val _liveData = MutableLiveData<String>()
    val liveData: LiveData<String> = _liveData

    fun getAccount() = viewModelScope.launch {
        Log.d("Tanya", "getAccount")
        _liveData.value = firstInteractor.getAccount().toString()
    }
}