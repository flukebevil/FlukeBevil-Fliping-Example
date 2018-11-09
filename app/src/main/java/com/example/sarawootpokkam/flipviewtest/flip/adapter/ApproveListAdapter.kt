package com.example.sarawootpokkam.flipviewtest.flip.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.sarawootpokkam.flipviewtest.R
import com.example.sarawootpokkam.flipviewtest.model.Profile
import kotlinx.android.synthetic.main.item_tinker_card_view.view.*

class ApproveListAdapter : RecyclerView.Adapter<ApproveListAdapter.ApproveListHolder>() {

    private var data: MutableList<Profile> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ApproveListHolder =
        ApproveListHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_tinker_card_view_approve,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ApproveListHolder, position: Int) =
        holder.onBind(data[position])

    fun setItem(data: MutableList<Profile>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class ApproveListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun onBind(profile: Profile) {
            itemView.apply {
                profileImageView?.let { Glide.with(context).load(profile.url).into(it) }
                nameAgeTxt?.text = "${profile.name}  ${profile.age.toString()}"
                locationNameTxt?.text = profile.location
            }
        }
    }
}