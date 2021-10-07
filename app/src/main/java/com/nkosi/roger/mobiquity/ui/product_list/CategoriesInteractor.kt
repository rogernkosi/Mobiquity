package com.nkosi.roger.mobiquity.ui.product_list

import android.database.Observable
import com.nkosi.roger.mobiquity.base.BaseInteractor
import com.nkosi.roger.mobiquity.model.Category
import com.nkosi.roger.mobiquity.network.CategoryApi
import javax.inject.Inject

class CategoriesInteractor @Inject internal constructor(api: CategoryApi): BaseInteractor(api), CategoriesMvpInteractor {

    override fun getProducts() = api.getCategories()
}