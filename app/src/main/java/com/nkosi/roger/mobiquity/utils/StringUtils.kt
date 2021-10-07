package com.nkosi.roger.mobiquity.utils

object StringUtils {

    fun imageUri(suffix: String): String{
        return StringBuilder().append(BASE_URL).append(suffix).toString()
    }

    fun buildProductPrice(currency: String, value: String): String{
        return StringBuilder().append(currency).append(value).toString()
    }

}