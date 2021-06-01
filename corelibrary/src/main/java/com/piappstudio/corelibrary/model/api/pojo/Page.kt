package com.piappstudio.corelibrary.model.api.pojo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.piappstudio.corelibrary.model.api.pojo.CardInfo
import kotlinx.parcelize.Parcelize

@Parcelize
data class Page (
    @SerializedName("cards")
    val cards:ArrayList<CardInfo>):Parcelable