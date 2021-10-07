package com.nkosi.roger.mobiquity.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
	val id: Int,
	val categoryId: Int,
	val name: String,
	val url: String,
	val description: String,
	val salePrice: SalePrice
) : Parcelable
