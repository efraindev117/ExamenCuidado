package com.example.examencuidado.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GitResponseUserItem(
    val id: Int,
    val login: String,
    val avatar_url: String,
    ) : Parcelable