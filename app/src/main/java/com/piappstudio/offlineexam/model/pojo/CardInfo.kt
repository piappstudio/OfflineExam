package com.piappstudio.offlineexam.model.pojo

import com.google.gson.annotations.SerializedName

data class CardInfo(
    @SerializedName("card_type") val card_type:String,
    @SerializedName("card") val card:Card)

 enum class CardType(val type:String) {
     NONE(""),
    TEXT("text"),
    TITLE_DESCRIPTION ("title_description"),
    IMAGE_TITLE_DESCRIPTION("image_title_description");

     companion object  {
         fun from(findType:String):CardType = values().firstOrNull() {
             it.type == findType
         }?:NONE
     }
 }