package com.pabloc.qrcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.pabloc.qrcode.databinding.ActivityOrderlistBinding
import kotlinx.android.synthetic.main.activity_orderlist.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OrderlistActivity : AppCompatActivity() {
    lateinit var binding: ActivityOrderlistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_orderlist)
        binding = ActivityOrderlistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()

    }

    private fun setAdapter(orderList: List<OrderDtoList>){
        val mAdapter = RecyclerAdapter(orderList,this)
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(false)

    }

    private fun loadData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://ec2-43-200-96-34.ap-northeast-2.compute.amazonaws.com:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService = retrofit.create(RetrofitInterface::class.java)
        retrofitService.requestAllData().enqueue(object : Callback<OrderData> {
            override fun onResponse(call: Call<OrderData>, response: Response<OrderData>) {
                if (response.isSuccessful) {
                    Log.d("chaehyun","연결완료")
                    val body = response.body()
                    body?.let {
                        setAdapter(it.result)
                    }
                }
            }

            override fun onFailure(call: Call<OrderData>, t: Throwable) {
                t.message?.let { Log.d("this is error", it) }
            }
        })
    }

}

