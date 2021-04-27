package com.piappstudio.offlineexam.model.pojo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Card(val value:String?,
                val attributes:Attribute?, val image:Image?, val title:Title?,
                val description: Description?): Parcelable
