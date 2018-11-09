package com.example.sarawootpokkam.flipviewtest.flip.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.example.sarawootpokkam.flipviewtest.R
import com.example.sarawootpokkam.flipviewtest.model.Item
import kotlinx.android.synthetic.main.item_flip_page.view.*

class MyFlipAdapter : BaseAdapter() {

    private var item: MutableList<Item> = arrayListOf()
    lateinit var pageRequestChange: OnRequestChangePageListener

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        return MyFlipHolder(
            LayoutInflater.from(parent?.context).inflate(R.layout.item_flip_page, parent, false)
        ).onBind(
            item[position]
        )
    }

    override fun getItem(position: Int): Any = item[position]

    override fun getItemId(position: Int): Long = 0L

    override fun getCount(): Int = item.size

    fun setItem(item: MutableList<Item>) {
        this.item = item
        notifyDataSetChanged()
    }

    /**
     * use this for add some action on listview when click it should be scrolling to target position
     */
    fun setPageChangeListener(pageRequestChange: OnRequestChangePageListener) {
        this.pageRequestChange = pageRequestChange
    }

    interface OnRequestChangePageListener {
        fun onPageChangeListener(position: Int?)
    }

    inner class MyFlipHolder(private val view: View?) {
        fun onBind(item: Item?): View? {
            return view?.apply {
                setUpToolbar(item?.text)
                tvName.text = item?.name
                Glide.with(context).load(item?.image).into(ivProfile)
            }
        }

        private fun setUpToolbar(text: String?) {
            view?.toolbar?.apply {
                title = text
                setNavigationOnClickListener { pageRequestChange.onPageChangeListener(0) }
            }
        }
    }
}