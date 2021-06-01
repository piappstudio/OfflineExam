package com.piappstudio.corelibrary.model.api.pojo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardInfo(
    @SerializedName("card_type") val card_type:String,
    @SerializedName("card") val card: Card
):Parcelable {
    val cardType get() = CardType.from(card_type)
}


 enum class CardType(val type:String) {
     NONE(""),
    TEXT("text"),
    TITLE_DESCRIPTION ("title_description"),
    IMAGE_TITLE_DESCRIPTION("image_title_description");

     companion object  {
         fun from(findType:String): CardType = values().firstOrNull() {
             it.type == findType
         }?: NONE
     }
 }