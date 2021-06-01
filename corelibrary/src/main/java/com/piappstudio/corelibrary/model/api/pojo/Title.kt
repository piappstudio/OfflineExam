package com.piappstudio.corelibrary.model.api.pojo

import android.os.Parcelable
import com.piappstudio.corelibrary.model.api.pojo.Attribute
import kotlinx.parcelize.Parcelize

@Parcelize
data class Title(val value:String, val attributes: Attribute): Parcelable
