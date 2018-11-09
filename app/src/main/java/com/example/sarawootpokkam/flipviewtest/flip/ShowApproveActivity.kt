package com.example.sarawootpokkam.flipviewtest.flip

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.sarawootpokkam.flipviewtest.KEY_PROFILE_APPROVE
import com.example.sarawootpokkam.flipviewtest.R
import com.example.sarawootpokkam.flipviewtest.flip.adapter.ApproveListAdapter
import com.example.sarawootpokkam.flipviewtest.model.ListProfile
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_show_approve.*

class ShowApproveActivity : AppCompatActivity() {

    private val adapter = ApproveListAdapter()
    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_approve)
        rvProfile?.apply {
            adapter = this@ShowApproveActivity.adapter
            layoutManager = LinearLayoutManager(this@ShowApproveActivity)
        }
        val json = intent?.getStringExtra(KEY_PROFILE_APPROVE)
        val data = gson.fromJson(json, ListProfile::class.java)
        data.data?.let { adapter.setItem(it) }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}