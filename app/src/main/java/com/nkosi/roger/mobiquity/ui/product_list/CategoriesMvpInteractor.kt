package com.nkosi.roger.mobiquity.ui.product_list

import com.nkosi.roger.mobiquity.base.MvpInteractor
import com.nkosi.roger.mobiquity.model.Category
import io.reactivex.Observable

interface CategoriesMvpInteractor: MvpInteractor {

    fun getProducts(): Observable<List<Category>>
}