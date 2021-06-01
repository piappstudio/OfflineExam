package com.piappstudio.corelibrary.model.api.pojo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(val url:String, val size: Size): Parcelable