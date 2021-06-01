package com.piappstudio.corelibrary.model.api.pojo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Font(
    @SerializedName("size")
    val size:Int): Parcelable