package com.piappstudio.offlineexam.model.pojo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Font(
    @SerializedName("size")
    val size:Int): Parcelable