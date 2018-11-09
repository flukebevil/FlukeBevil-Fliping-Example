package com.example.sarawootpokkam.flipviewtest.tinder

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.sarawootpokkam.flipviewtest.KEY_PROFILE_APPROVE
import com.example.sarawootpokkam.flipviewtest.R
import com.example.sarawootpokkam.flipviewtest.flip.ShowApproveActivity
import com.example.sarawootpokkam.flipviewtest.model.ListProfile
import com.example.sarawootpokkam.flipviewtest.model.Profile
import com.example.sarawootpokkam.flipviewtest.receiveData
import com.google.gson.Gson
import com.mindorks.placeholderview.SwipeDecor
import com.mindorks.placeholderview.SwipePlaceHolderView
import com.mindorks.placeholderview.SwipeViewBuilder
import kotlinx.android.synthetic.main.activity_tinder_swip.*

class TinDerActivity : AppCompatActivity(), Tinder.SwipeListener {

    private val acceptList: ListProfile = ListProfile()
    private val acceptData: MutableList<Profile> = arrayListOf()
    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tinder_swip)

        swipeView.getBuilder<SwipePlaceHolderView, SwipeViewBuilder<SwipePlaceHolderView>>()
            .setDisplayViewCount(3)
            .setSwipeDecor(
                SwipeDecor()
                    .setPaddingTop(0)
                    .setRelativeScale(0.01f)
                    .setSwipeInMsgLayoutId(R.layout.item_swipe_accept)
                    .setSwipeOutMsgLayoutId(R.layout.item_swipe_reject)
            )
        btnViewApprove.setOnClickListener {
            acceptData.size.takeIf { size -> size != 0 }?.apply {
                acceptList.data = acceptData
                startActivity(Intent(this@TinDerActivity, ShowApproveActivity::class.java).apply {
                    putExtra(KEY_PROFILE_APPROVE, gson.toJson(acceptList))
                })
            } ?: kotlin.run {
                Toast.makeText(this@TinDerActivity, "Empty", Toast.LENGTH_SHORT).show()
            }
        }
        addItem()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onSwipeIn(profile: Profile) {
        acceptData.add(profile)
    }

    override fun onSwipeOut(profile: Profile) {
    }

    private fun addItem() {
        val profile = this.receiveData<ListProfile>()
        profile.data?.forEach { profileData ->
            swipeView.addView(Tinder(this, profileData, swipeView, this))
        }
    }
}