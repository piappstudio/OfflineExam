package com.piappstudio.offlineexam.ui.list

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.piappstudio.offlineexam.R
import com.piappstudio.offlineexam.common.setAttribute
import com.piappstudio.offlineexam.model.pojo.CardInfo
import com.piappstudio.offlineexam.model.pojo.CardType
import kotlin.math.min

/**
 * Home List adapter to render the recycler view
 * */
class HomeListAdapter(var lstList: List<CardInfo>): RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {


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

    /**
     * To render text only item
     * */
    open inner class TextViewHolder(view: View):ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.tvTitle)
        override fun onBind(position: Int) {
            val cardInfo = lstList[position]
            title.text = cardInfo.card.value
            title.setAttribute(cardInfo.card.attributes)
        }
    }

    /**
     * To render title with description item
     * */
    open inner class TitleDescription(view: View):ViewHolder(view) {
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

    /**
     * To render Image, Title and Description item
     * */
    open inner class ImageTitleDescription(val view: View):ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.tvTitle)
        private val description = view.findViewById<TextView>(R.id.tvDescription)
        private val image = view.findViewById<ImageView>(R.id.ivHome)
        private val container = view.findViewById<ConstraintLayout>(R.id.clContainer)

        override fun onBind(position: Int) {
            container.invalidate()
            container.requestLayout()
            val cardInfo = lstList[position]
            title.text = cardInfo.card.title?.value
            title.setAttribute(cardInfo.card.title?.attributes)
            description.text = cardInfo.card.description?.value
            description.setAttribute(cardInfo.card.description?.attributes)

            val size = cardInfo.card.image?.size
            Glide.with(image).load(cardInfo.card.image?.url).apply( RequestOptions().override(size?.width?:0, size?.height?:0))
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(R.drawable.ic_cloud_storage_download)
                    .into(image)
            view.layoutParams = ConstraintLayout.LayoutParams(min(view.layoutParams.width, size?.width?:0), size?.height?:0)

        }
    }

    /**
     * Abstract class to define the contract
     * */
    abstract class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        abstract fun onBind(position: Int)
    }
}