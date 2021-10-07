package com.nkosi.roger.mobiquity.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SalePrice(val amount : Double, val currency : String): Parcelable