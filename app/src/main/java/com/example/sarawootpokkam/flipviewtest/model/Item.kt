package com.example.sarawootpokkam.flipviewtest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    var id: Int? = null,
    var text: String? = null,
    var name: String? = null,
    var image: String? = null
) : Parcelable