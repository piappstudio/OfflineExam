package com.piappstudio.offlineexam.ui.tiles

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.piappstudio.corelibrary.model.api.pojo.CardInfo
import com.piappstudio.offlineexam.R
import com.piappstudio.offlineexam.common.setAttribute
import kotlin.math.min

class ImageTitleDescriptionViewHolder(private val view:View):BaseViewHolder(view) {
    private val title = view.findViewById<TextView>(R.id.tvTitle)
    private val description = view.findViewById<TextView>(R.id.tvDescription)
    private val image = view.findViewById<ImageView>(R.id.ivHome)
    private val container = view.findViewById<ConstraintLayout>(R.id.clContainer)

    override fun onBind(data: Any) {
        data as CardInfo
        container.invalidate()
        container.requestLayout()
        title.text = data.card.title?.value
        title.setAttribute(data.card.title?.attributes)
        description.text = data.card.description?.value
        description.setAttribute(data.card.description?.attributes)

        val size = data.card.image?.size
        Glide.with(image).load(data.card.image?.url).apply( RequestOptions().override(size?.width?:0, size?.height?:0))
            .transition(DrawableTransitionOptions.withCrossFade())
            .placeholder(R.drawable.ic_cloud_storage_download)
            .into(image)
        view.layoutParams = ConstraintLayout.LayoutParams(min(view.layoutParams.width, size?.width?:0), size?.height?:0)
    }
}