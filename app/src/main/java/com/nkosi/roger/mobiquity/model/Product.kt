package com.nkosi.roger.mobiquity.model

data class Product(
	val id: Int,
	val categoryId: Int,
	val name: String,
	val url: String,
	val description: String,
	val salePrice: SalePrice
)