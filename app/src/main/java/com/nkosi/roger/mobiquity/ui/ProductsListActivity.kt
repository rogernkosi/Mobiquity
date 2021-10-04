package com.nkosi.roger.mobiquity.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.nkosi.roger.mobiquity.R
import com.nkosi.roger.mobiquity.base.BaseActivity
import com.nkosi.roger.mobiquity.model.Category

class ProductsListActivity : BaseActivity<CategoriesPresenter>(), CategoriesView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_list)

        presenter.onViewCreated()
    }

    override fun instantiatePresenter(): CategoriesPresenter {
        return CategoriesPresenter(this)
    }

    override fun showCategories(posts: List<Category>) {
        Log.e("categories", posts.toString())
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