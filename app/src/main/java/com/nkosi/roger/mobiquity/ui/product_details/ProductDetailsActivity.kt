package com.nkosi.roger.mobiquity.ui.product_details

import android.os.Bundle
import com.bumptech.glide.Glide
import com.nkosi.roger.mobiquity.R
import com.nkosi.roger.mobiquity.base.BaseActivity
import com.nkosi.roger.mobiquity.model.Product
import com.nkosi.roger.mobiquity.utils.StringUtils
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetailsActivity : BaseActivity<ProductPresenter>(), ProductView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        presenter.onViewCreated()
    }

    override fun instantiatePresenter(): ProductPresenter {
        return ProductPresenter(this)
    }

    override fun showProduct(product: Product) {
        product_name.text = product.name
        product_price.text = StringUtils.buildProductPrice(product.salePrice.currency, product.salePrice.amount.toString())

        Glide
            .with(this)
            .load(StringUtils.imageUri(product.url))
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_fastfood_24)
            .into(product_image)
    }

    override fun getData() {
        val product = intent.getParcelableExtra<Product>("product")
        presenter.onDataReady(product!!)
    }

    override fun showError(error: String) {
        TODO("Not yet implemented")
    }

    override fun showLoading() {
        // loading
    }

    override fun hideLoading() {
        // hide loading
    }
}