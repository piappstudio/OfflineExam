package com.piappstudio.offlineexam.common

import android.graphics.Color
import android.widget.TextView
import com.piappstudio.offlineexam.model.pojo.Attribute

fun TextView.setAttribute(attribute:Attribute?) {
    this.setTextColor(Color.parseColor(attribute?.textColor))
    attribute?.font?.size?.let {
        this.textSize = it.toFloat()
    }
}