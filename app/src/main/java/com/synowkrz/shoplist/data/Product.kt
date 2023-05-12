package com.synowkrz.shoplist.data

data class Product(
    val id: Long,
    val name: String,
    val icon: Int,
    val amount: Int = 0,
)