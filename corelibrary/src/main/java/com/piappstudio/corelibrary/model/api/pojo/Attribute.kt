package com.piappstudio.corelibrary.model.api.pojo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Attribute(
    @SerializedName("text_color")
    val textColor:String,
    @SerializedName("font")
    val font: Font
):Parcelable
