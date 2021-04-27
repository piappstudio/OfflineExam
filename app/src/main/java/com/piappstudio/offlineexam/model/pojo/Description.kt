package com.piappstudio.offlineexam.model.pojo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Description(val value:String, val attributes:Attribute): Parcelable