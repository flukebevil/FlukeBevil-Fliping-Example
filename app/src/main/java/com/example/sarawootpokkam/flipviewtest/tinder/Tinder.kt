package com.example.sarawootpokkam.flipviewtest.tinder

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.sarawootpokkam.flipviewtest.R
import com.example.sarawootpokkam.flipviewtest.model.Profile
import com.mindorks.placeholderview.SwipePlaceHolderView
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState
import com.mindorks.placeholderview.annotations.swipe.SwipeIn
import com.mindorks.placeholderview.annotations.swipe.SwipeInState
import com.mindorks.placeholderview.annotations.swipe.SwipeOut
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState

@Layout(R.layout.item_tinker_card_view)
class Tinder(
    var context: Context,
    var profile: Profile,
    var swipeView: SwipePlaceHolderView,
    var callback: SwipeListener
) {

    @View(R.id.profileImageView)
    private val profileImageView: ImageView? = null

    @View(R.id.nameAgeTxt)
    private val nameAgeTxt: TextView? = null

    @View(R.id.locationNameTxt)
    private val locationNameTxt: TextView? = null

    /**
     * bind a method to be executed when the view is ready to be used
     */
    @SuppressLint("SetTextI18n")
    @Resolve
    fun onResolve() {
        profileImageView?.let { Glide.with(context).load(profile.url).into(it) }
        nameAgeTxt?.text = "${profile.name}  ${profile.age.toString()}"
        locationNameTxt?.text = profile.location
    }

    @SwipeOut
    private fun onSwipedOut() {}

    @SwipeCancelState
    private fun onSwipeCancelState() {}

    @SwipeIn
    private fun onSwipeIn() {
        callback.onSwipeIn(profile)
    }

    @SwipeInState
    private fun onSwipeInState() {}

    @SwipeOutState
    private fun onSwipeOutState() {}

    interface SwipeListener {
        fun onSwipeIn(profile: Profile)
        fun onSwipeOut(profile: Profile)
    }
}