package com.example.adalab_android_apis

data class ProductResponse(
    var products:List<Products>,
    var total:Int,
    var skip:Int,
    var limit:Int
)
