package com.piappstudio.offlineexam.model.pojo

import com.google.gson.annotations.SerializedName

data class Page (
    @SerializedName("cards")
    val cards:ArrayList<CardInfo>)