package com.piappstudio.offlineexam.common

import android.graphics.Color
import android.widget.TextView
import com.piappstudio.offlineexam.model.pojo.Attribute

/**
 * To set the text view attribute based on Attribute value
 * */
fun TextView.setAttribute(attribute: Attribute?) {
    this.setTextColor(Color.parseColor(attribute?.textColor))
    attribute?.font?.size?.let {
        this.textSize = it.toFloat()
    }
}