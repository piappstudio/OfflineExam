package com.piappstudio.offlineexam.ui.list

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.piappstudio.offlineexam.R
import com.piappstudio.offlineexam.common.setAttribute
import com.piappstudio.offlineexam.model.pojo.CardInfo
import com.piappstudio.offlineexam.model.pojo.CardType

/**
 * Home List adapter to render the recycler view
 * */
class HomeListAdapter(var lstList:List<CardInfo>, val context:Context): RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {


    val TAG = HomeListAdapter::class.java.name
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return when (CardType.values()[viewType]) {
            CardType.IMAGE_TITLE_DESCRIPTION -> {
                Log.d(TAG, "Loading Image, Title description")
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_image_tile, parent, false)
                ImageTitleDescription(view)
            }
            CardType.TITLE_DESCRIPTION -> {
                Log.d(TAG, "Loading Title description")

                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_title_description, parent, false)
                TitleDescription(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_text, parent, false)
                TextViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)
    }


    override fun getItemViewType(position: Int): Int {
        val cardInfo = lstList[position]
        return cardInfo.cardType.ordinal
    }
    override fun getItemCount(): Int {
        return lstList.size
    }

    open inner class TextViewHolder(view:View):ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.tvTitle)
        override fun onBind(position: Int) {
            val cardInfo = lstList[position]
            title.text = cardInfo.card.value
            title.setAttribute(cardInfo.card.attributes)
        }
    }

    open inner class TitleDescription(view:View):ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.tvTitle)
        private val description = view.findViewById<TextView>(R.id.tvDescription)

        override fun onBind(position: Int) {
            val cardInfo = lstList[position]
            title.text = cardInfo.card.title?.value
            title.setAttribute(cardInfo.card.title?.attributes)
            description.text = cardInfo.card.description?.value
            description.setAttribute(cardInfo.card.description?.attributes)
        }
    }

    open inner class ImageTitleDescription(view: View):ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.tvTitle)
        private val description = view.findViewById<TextView>(R.id.tvDescription)
        private val image = view.findViewById<ImageView>(R.id.ivHome)

        override fun onBind(position: Int) {
            val cardInfo = lstList[position]
            title.text = cardInfo.card.title?.value
            title.setAttribute(cardInfo.card.title?.attributes)
            description.text = cardInfo.card.description?.value
            description.setAttribute(cardInfo.card.description?.attributes)
            Glide.with(image).load(cardInfo.card.image?.url)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade()).
                placeholder(R.drawable.ic_pi).into(image)
        }
    }

    abstract class ViewHolder(view:View): RecyclerView.ViewHolder(view) {
        abstract fun onBind(position:Int)
    }
}