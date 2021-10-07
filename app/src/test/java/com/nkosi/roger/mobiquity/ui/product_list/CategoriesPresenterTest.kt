package com.nkosi.roger.mobiquity.ui.product_list

import com.nkosi.roger.mobiquity.model.Category
import com.nkosi.roger.mobiquity.model.Product
import com.nkosi.roger.mobiquity.network.CategoryApi
import com.nkosi.roger.mobiquity.ui.product_list.utils.RxImmediateSchedulerRule
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.observers.TestObserver
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.stubbing.Answer

class CategoriesPresenterTest {

    @Mock
    lateinit var categoriesView: CategoriesView
    @Mock
    lateinit var api: CategoryApi

    lateinit var presenter: CategoriesPresenter

    @Before
    fun setUp() {
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        MockitoAnnotations.initMocks(this);
        presenter = CategoriesPresenter(categoriesView)
    }

    @Test
    fun `test_show_categories_with_products_if_success`() {
       `when`(api.getCategories()).thenReturn(Observable.just(listOf()))

        presenter.loadProducts()
        val result = presenter.subscription
        val testObserver = TestObserver<List<Category>>()
    }

}