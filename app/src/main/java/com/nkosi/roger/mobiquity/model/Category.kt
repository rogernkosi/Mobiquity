package com.nkosi.roger.mobiquity.model

data class Category (
    val id : Int,
    val name : String,
    val description : String,
    val products : List<Products>
)