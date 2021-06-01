package com.piappstudio.offlineexam.common

import com.piappstudio.corelibrary.model.api.pojo.CardType
import com.piappstudio.offlineexam.R
import com.piappstudio.offlineexam.ui.tiles.ImageTitleDescriptionViewHolder
import com.piappstudio.offlineexam.ui.tiles.TextViewHolder
import com.piappstudio.offlineexam.ui.tiles.TitleDescriptionViewHolder
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TileManager @Inject constructor()  {
    val mTileMap = HashMap<String, Pair<Int, Class<*>>>()
    init {
        mTileMap[CardType.TITLE_DESCRIPTION.name] =
            Pair(R.layout.item_home_title_description, TitleDescriptionViewHolder::class.java)
        mTileMap[CardType.IMAGE_TITLE_DESCRIPTION.name] =
            Pair(R.layout.item_home_image_tile, ImageTitleDescriptionViewHolder::class.java)
        mTileMap[CardType.TEXT.name] =
            Pair(R.layout.item_home_text, TextViewHolder::class.java)
    }
}