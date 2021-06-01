package com.piappstudio.offlineexam.ui.tiles

import android.view.View
import android.widget.TextView
import com.piappstudio.corelibrary.model.api.pojo.CardInfo
import com.piappstudio.offlineexam.R
import com.piappstudio.offlineexam.common.setAttribute

class TitleDescriptionViewHolder(view: View): BaseViewHolder(view) {
    private val title = view.findViewById<TextView>(R.id.tvTitle)
    private val description = view.findViewById<TextView>(R.id.tvDescription)

    override fun onBind(data: Any) {
        data as CardInfo
        title.text = data.card.title?.value
        title.setAttribute(data.card.title?.attributes)
        description.text = data.card.description?.value
        description.setAttribute(data.card.description?.attributes)
    }
}