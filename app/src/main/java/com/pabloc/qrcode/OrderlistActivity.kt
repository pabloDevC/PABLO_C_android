package com.pabloc.qrcode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.pabloc.qrcode.databinding.ActivityOrderlistBinding
import kotlinx.android.synthetic.main.item_list.*

class OrderlistActivity : AppCompatActivity() {
    lateinit var binding: ActivityOrderlistBinding
    private lateinit var adapter: RecyclerAdapter
    val mDatas = mutableListOf<DogData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_orderlist)
        binding = ActivityOrderlistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnScanner.setOnClickListener {
            val intent = Intent(this, ScannerActivity::class.java)
            startActivity(intent)
        }
//        loadData()
        initializelist()
        initDogRecyclerView()

    }

    fun initDogRecyclerView() {
        val adapter = RecyclerAdapter() //어댑터 객체 만듦
        adapter.datalist = mDatas //데이터 넣어줌
        binding.recyclerView.adapter = adapter //리사이클러뷰에 어댑터 연결
        binding.recyclerView.layoutManager = LinearLayoutManager(this) //레이아웃 매니저 연결
    }

    fun initializelist() { //임의로 데이터 넣어서 만들어봄
        with(mDatas) {
            add(DogData("1", "dog1", 2))
            add(DogData("2", "dog2", 3))
            add(DogData("3", "dog3", 5))
            add(DogData("4", "dog4", 10))
            add(DogData("5", "dog5", 4))
            add(DogData("6", "dog6", 3))
            add(DogData("7", "dog7", 2))
            add(DogData("8", "dog8", 3))
            add(DogData("9", "dog9", 5))
            add(DogData("10", "dog10", 10))
            add(DogData("11", "dog11", 4))
            add(DogData("12", "dog12", 3))
        }
    }
}

//    private fun setAdapter(orderList: List<OrderDtoList>){
////        val adapter=RecyclerAdapter(orderList,this) //어댑터 객체 만듦
////        adapter.postList=orderList //데이터 넣어줌
////        binding.recyclerView.adapter=adapter //리사이클러뷰에 어댑터 연결
//        val adapter = RecyclerAdapter(orderList,this)
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.setHasFixedSize(false)
//
//    }

//    private fun loadData() {
//        val retrofit = Retrofit.Builder()
//            .baseUrl("http://ec2-43-200-96-34.ap-northeast-2.compute.amazonaws.com:8080/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val retrofitService = retrofit.create(RetrofitInterface::class.java)
//        retrofitService.requestAllData().enqueue(object : Callback<OrderData> {
//            override fun onResponse(call: Call<OrderData>, response: Response<OrderData>) {
//                if (response.isSuccessful) {
//                    Log.d("chaehyun","연결완료")
//                    val body = response.body()
//                    body?.let {
//                        setAdapter(it.result)
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<OrderData>, t: Throwable) {
//                t.message?.let { Log.d("this is error", it) }
//            }
//        })
//    }

//}

