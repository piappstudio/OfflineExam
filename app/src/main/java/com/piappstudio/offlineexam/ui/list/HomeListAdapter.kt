package com.piappstudio.offlineexam.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.piappstudio.corelibrary.model.api.pojo.CardInfo
import com.piappstudio.corelibrary.model.api.pojo.CardType
import com.piappstudio.offlineexam.common.TileManager
import com.piappstudio.offlineexam.ui.tiles.BaseViewHolder

/**
 * Home List adapter to render the recycler view
 * */

class HomeListAdapter(var lstList: List<CardInfo>, var tileManager: TileManager): RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
         val pairInfo = tileManager.mTileMap[CardType.values()[viewType].name]
        val view = LayoutInflater.from(parent.context).inflate(pairInfo!!.first, parent, false)
        return pairInfo.second.getConstructor(View::class.java)
            ?.newInstance(view) as BaseViewHolder
    }


    override fun getItemViewType(position: Int): Int {
        val cardInfo = lstList[position]
        return cardInfo.cardType.ordinal
    }
    override fun getItemCount(): Int {
        return lstList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(lstList[position])
    }
}