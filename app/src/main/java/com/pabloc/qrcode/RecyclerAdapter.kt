package com.pabloc.qrcode

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val postList: List<OrderDtoList>, val context: Context)
    : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return RecyclerAdapter.ViewHolder(
            LayoutInflater.from(context)
            .inflate(R.layout.item_list, parent ,false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postList[position],context)
    }

    override fun getItemCount(): Int {
        return postList.count()
    }


    class ViewHolder (itemView: View? ) : RecyclerView.ViewHolder(itemView!!){

        val orderPK = itemView?.findViewById<TextView>(R.id.orderPK)
//        val productName = itemView?.findViewById<TextView>(R.id.productName)
//        val productCount  = itemView?.findViewById<TextView>(R.id.productCount)

        fun bind(orderList: OrderDtoList, context: Context){
            orderPK?.text = orderList?.orderPK.toString()
//            productName?.text = orderList?.itemList.productName
//            productCount?.text = orderList?.productCount.toString()
            Log.d("chaehyun"," $orderPK 입니다")
        }

    }
}