package com.piappstudio.offlineexam.ui.tiles

import android.view.View
import android.widget.TextView
import com.piappstudio.corelibrary.model.api.pojo.CardInfo
import com.piappstudio.offlineexam.R
import com.piappstudio.offlineexam.common.setAttribute

class TextViewHolder(view: View): BaseViewHolder(view) {
    private val title = view.findViewById<TextView>(R.id.tvTitle)
    override fun onBind(data: Any) {
        data as CardInfo
        title.text = data.card.value
        title.setAttribute(data.card.attributes)
    }
}