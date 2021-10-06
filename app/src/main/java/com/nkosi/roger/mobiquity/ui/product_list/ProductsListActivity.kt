package com.nkosi.roger.mobiquity.ui.product_list

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nkosi.roger.mobiquity.R
import com.nkosi.roger.mobiquity.base.BaseActivity
import com.nkosi.roger.mobiquity.model.Category

class ProductsListActivity : BaseActivity<CategoriesPresenter>(), CategoriesView {

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
    }

    override fun instantiatePresenter(): CategoriesPresenter {
        return CategoriesPresenter(this)
    }

    override fun showCategories(products: List<Category>) {
        adapterCategoryAdapter.setData(products)
    }

    override fun showError(error: String) {
        Log.e("error", error)
    }

    override fun showLoading() {
        Toast.makeText(this, "loading", Toast.LENGTH_SHORT).show()
    }

    override fun hideLoading() {
    }
}