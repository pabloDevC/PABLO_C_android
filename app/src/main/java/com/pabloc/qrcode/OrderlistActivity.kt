package com.pabloc.qrcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.pabloc.qrcode.databinding.ActivityOrderlistBinding

class OrderlistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderlistBinding
    private lateinit var adapter: RecyclerViewAdapter

    val mDatas=mutableListOf<DogData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityOrderlistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializelist()
        initDogRecyclerView()

    }
    fun initDogRecyclerView(){
        val adapter=RecyclerViewAdapter() //어댑터 객체 만듦
        adapter.datalist = mDatas //데이터 넣어줌
        binding.recyclerView.adapter = adapter //리사이클러뷰에 어댑터 연결
        binding.recyclerView.layoutManager= LinearLayoutManager(this) //레이아웃 매니저 연결
    }

    fun initializelist(){ //임의로 데이터 넣어서 만들어봄
        with(mDatas){
            add(DogData("","dog1",20,"M"))
            add(DogData("","dog2",20,"M"))
            add(DogData("","dog3",20,"M"))
            add(DogData("","dog4",20,"M"))
            add(DogData("","dog5",20,"M"))
            add(DogData("","dog2",20,"M"))
            add(DogData("","dog6",20,"M"))
            add(DogData("","dog7",20,"M"))
            add(DogData("","dog8",20,"M"))
            add(DogData("","dog9",20,"M"))
            add(DogData("","dog10",20,"M"))
            add(DogData("","dog11",20,"M"))
            add(DogData("","dog12",20,"M"))
        }
    }
}
