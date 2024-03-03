package com.example.sealsmartapp.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AccountModel(
    val id: Long,
    val email: String,
    val username: String,
    val createdAt: Long
) : Parcelable
