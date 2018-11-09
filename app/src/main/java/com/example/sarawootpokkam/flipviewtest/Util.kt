package com.example.sarawootpokkam.flipviewtest

import android.app.Activity
import com.google.gson.Gson

inline fun <reified T> Activity.receiveData(): T {
    val gson = Gson()
    val jSon = application.assets.open("profile.json").bufferedReader().use {
        it.readText()
    }
    return gson.fromJson(jSon, T::class.java)
}