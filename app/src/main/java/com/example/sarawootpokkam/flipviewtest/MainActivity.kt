package com.example.sarawootpokkam.flipviewtest

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.sarawootpokkam.flipviewtest.flip.MainFlip
import com.example.sarawootpokkam.flipviewtest.tinder.TinDerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFlipBoard.setOnClickListener {
            startActivity(Intent(this, MainFlip::class.java))
        }
        btnTinder.setOnClickListener {
            startActivity(Intent(this, TinDerActivity::class.java))
        }
    }
}