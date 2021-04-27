package com.piappstudio.offlineexam.model.pojo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Page (
    @SerializedName("cards")
    val cards:ArrayList<CardInfo>):Parcelable