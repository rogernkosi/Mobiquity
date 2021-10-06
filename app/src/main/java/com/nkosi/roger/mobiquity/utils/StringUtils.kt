package com.nkosi.roger.mobiquity.utils

object StringUtils {

    fun imageUri(suffix: String): String{
        return StringBuilder().append(BASE_URL).append(suffix).toString()
    }

}