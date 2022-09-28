package com.pabloc.qrcode

import com.google.gson.annotations.SerializedName

data class OrderData(
    @SerializedName("isSuccess")
    val isSuccess: Boolean,
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    var result : List<OrderDtoList>,
)

data class OrderDtoList(
    @SerializedName("orderPK")
    val orderPK: Int,
//    orders => itemList
    @SerializedName("itemList")
    var itemList : List<Order>
)

data class Order(
    @SerializedName("productName")
    val productName: String,
    @SerializedName("productCount")
    val productCount : Int,
)
