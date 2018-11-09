package com.example.sarawootpokkam.flipviewtest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Profile(
    var age: Int? = null,
    var location: String? = null,
    var name: String? = null,
    var url: String? = null
) : Parcelable

data class ListProfile(
    var data: MutableList<Profile>? = null
)