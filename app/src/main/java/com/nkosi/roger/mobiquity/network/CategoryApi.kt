package com.nkosi.roger.mobiquity.network

import com.nkosi.roger.mobiquity.model.Category
import io.reactivex.Observable
import retrofit2.http.GET

interface CategoryApi {

    /**
     * Get the list of the pots from the API
     */
    @GET("/")
    fun getCategories(): Observable<List<Category>>

}