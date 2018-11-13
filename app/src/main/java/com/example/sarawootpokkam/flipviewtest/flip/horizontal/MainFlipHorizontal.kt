package com.example.sarawootpokkam.flipviewtest.flip.horizontal

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.aphidmobile.flip.FlipViewController
import com.example.sarawootpokkam.flipviewtest.flip.adapter.MyFlipAdapter
import com.example.sarawootpokkam.flipviewtest.model.Item

class MainFlipHorizontal : AppCompatActivity() {

    lateinit var flip: FlipViewController
    private val flipAdapter = MyFlipAdapter()
    private val listData: MutableList<Item> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        flip = FlipViewController(this, FlipViewController.HORIZONTAL).apply {
            adapter = flipAdapter
        }
        setContentView(flip)
        addData()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun addData() {
        listData.add(
            Item(
                1,
                "Hero in Bitch World",
                "John Wick",
                "https://upload.wikimedia.org/wikipedia/en/thumb/9/98/John_Wick_TeaserPoster.jpg/220px-John_Wick_TeaserPoster.jpg"
            )
        )
        listData.add(
            Item(
                2,
                "Hero in Bitch World",
                "John Snow",
                "https://upload.wikimedia.org/wikipedia/en/thumb/f/f0/Jon_Snow-Kit_Harington.jpg/220px-Jon_Snow-Kit_Harington.jpg"
            )
        )
        listData.add(
            Item(
                3,
                "Hero in Bitch World",
                "John Rain",
                "https://www.thoughtco.com/thmb/8vrwFz04uskj25rAk-6NPDoxEK4=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-591910329-56f6b5243df78c78418c3124.jpg"
            )
        )
        listData.add(
            Item(
                4,
                "Hero in Bitch World",
                "John Sunny",
                "https://bloximages.newyork1.vip.townnews.com/northwestgeorgianews.com/content/tncms/assets/v3/editorial/9/cf/9cf0d394-2352-11e3-9d30-001a4bcf6878/565f5a4629c30.image.jpg"
            )
        )
        listData.add(
            Item(
                5,
                "Hero in Bitch World",
                "John Cold",
                "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/cold-and-flu-1535040247.jpg?crop=1.00xw:0.446xh;0,0.266xh&resize=480:*"
            )
        )
        flipAdapter.isOldLibrary = true
        flipAdapter.setItem(listData)
    }
}
