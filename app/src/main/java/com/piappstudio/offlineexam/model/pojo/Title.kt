package com.piappstudio.offlineexam.model.pojo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Title(val value:String, val attributes:Attribute): Parcelable
