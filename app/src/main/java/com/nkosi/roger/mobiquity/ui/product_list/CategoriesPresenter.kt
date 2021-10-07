package com.nkosi.roger.mobiquity.ui.product_list

import com.nkosi.roger.mobiquity.base.BasePresenter
import com.nkosi.roger.mobiquity.model.Product
import com.nkosi.roger.mobiquity.network.CategoryApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CategoriesPresenter(categoriesView: CategoriesView): BasePresenter<CategoriesView>(categoriesView) {

    @Inject
    lateinit var categoryApi: CategoryApi

    private var subscription: Disposable? = null

    /**
     * Loads the products from the API and presents them in the view when retrieved, or show error if
     * any.
     */
    private fun loadProducts() {
        view.showLoading()
        subscription = categoryApi
            .getCategories()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate {
                view.hideLoading()
            }
            .subscribe(
                { view.showCategories(it)},
                { view.showError(it.localizedMessage!!)}
            )
    }

    /**
     *
     * the view notifies the presenter about a click even occurred
     *
     */
    fun onProductItemClicked(product: Product){
        view.navigateToDetailsActivity(product)
    }

    override fun onViewCreated() {
        loadProducts()
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}