package com.nkosi.roger.mobiquity.ui.product_list

import android.content.Intent
import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.nkosi.roger.mobiquity.R
import com.nkosi.roger.mobiquity.base.BaseActivity
import com.nkosi.roger.mobiquity.model.Category
import com.nkosi.roger.mobiquity.model.Product
import com.nkosi.roger.mobiquity.ui.product_details.ProductDetailsActivity
import kotlinx.android.synthetic.main.activity_products_list.*

class ProductsListActivity: BaseActivity<CategoriesPresenter>(), CategoriesView {

    private lateinit var recyclerView: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit  var adapterCategoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_list)

        recyclerView = findViewById(R.id.products_list)
        linearLayoutManager =  LinearLayoutManager(this)

        /*
        *
        * I do not see the need to inject the Adapter to the activity,
        * DI is used so we decouple our implementations from each other
        * but we do not implement the Android Activity nor the Android Recyclerview.Adapter
        * We also not gonna unit test our Activity and Adapter
        *
         */
        adapterCategoryAdapter = CategoryAdapter()
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapterCategoryAdapter
        presenter.onViewCreated()

        adapterCategoryAdapter.getEvent().subscribe { presenter.onProductItemClicked(it) }
    }

    override fun instantiatePresenter(): CategoriesPresenter {
        return CategoriesPresenter(this)
    }

    override fun showCategories(products: List<Category>) {
        adapterCategoryAdapter.setData(products)
    }

    override fun showError(error: String) {
        Snackbar.make(parent_product_list_view, error, Snackbar.LENGTH_LONG).show()
    }

    override fun showLoading() {
        loading_progressbar.show()
    }

    override fun hideLoading() {
        loading_progressbar.hide()
    }

    override fun navigateToDetailsActivity(product: Product) {
        val intent = Intent(this, ProductDetailsActivity::class.java)
        intent.putExtra("product", product)
        startActivity(intent)
    }
}