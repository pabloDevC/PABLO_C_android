package com.pabloc.qrcode

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.pabloc.qrcode.databinding.ItemListBinding
import kotlinx.android.synthetic.main.item_list.*

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    var datalist = mutableListOf<DogData>()//리사이클러뷰에서 사용할 데이터 미리 정의 -> 나중에 MainActivity등에서 datalist에 실제 데이터 추가

    inner class MyViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dogData: DogData) {
            //binding.dogPhotoImg.=dogData.dog_img
            binding.orderPK.text = dogData.orderPK
            binding.productName.text = dogData.productName
            binding.productCount.text = dogData.productCount.toString()
//            binding.mRootView.setOnClickListener {
//                val intent = Intent(this, PasswordActivity::class.java)
//                startActivity(intent)
//            }
        }
    }


    //만들어진 뷰홀더 없을때 뷰홀더(레이아웃) 생성하는 함수
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = datalist.size

    //recyclerview가 viewholder를 가져와 데이터 연결할때 호출
    //적절한 데이터를 가져와서 그 데이터를 사용하여 뷰홀더의 레이아웃 채움
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(datalist[position])

    }

}



//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(
//            LayoutInflater.from(context)
//            .inflate(R.layout.item_list, parent ,false))
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(postList[position],context)
//    }
//
//    override fun getItemCount(): Int {
//        return postList.count()
//    }
//
//
//    class ViewHolder (itemView: View? ) : RecyclerView.ViewHolder(itemView!!){
//
//        val orderPK = itemView?.findViewById<TextView>(R.id.orderPK)
////        val productName = itemView?.findViewById<TextView>(R.id.productName)
////        val productCount  = itemView?.findViewById<TextView>(R.id.productCount)
//
//        fun bind(orderList: OrderDtoList, context: Context){
//            orderPK?.text = orderList?.orderPK.toString()
////            productName?.text = orderList?.itemList.productName
////            productCount?.text = orderList?.productCount.toString()
//            Log.d("chaehyun"," $orderPK 입니다")
//        }
//
//    }
//}