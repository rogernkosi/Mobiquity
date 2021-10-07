package com.nkosi.roger.mobiquity.ui.product_details

import com.nkosi.roger.mobiquity.base.BasePresenter
import com.nkosi.roger.mobiquity.model.Product

class ProductPresenter(productView: ProductView): BasePresenter<ProductView>(productView) {

    override fun onViewCreated() {
        view.showLoading()
        view.getData()
    }

    override fun onViewDestroyed() {
        super.onViewDestroyed()
    }

    fun onDataReady(product: Product){
        view.showProduct(product)
        view.hideLoading()
    }
}