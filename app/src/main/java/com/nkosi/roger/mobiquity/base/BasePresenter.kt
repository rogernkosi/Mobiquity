package com.nkosi.roger.mobiquity.base

import com.nkosi.roger.mobiquity.di.component.DaggerInjector
import com.nkosi.roger.mobiquity.di.component.Injector
import com.nkosi.roger.mobiquity.di.modules.ContextModule
import com.nkosi.roger.mobiquity.di.modules.NetworkModule
import com.nkosi.roger.mobiquity.ui.product_list.CategoriesPresenter

/**
 * Base presenter any presenter of the application must extend. It provides initial injections and
 * required methods.
 * @param V the type of the View the presenter is based on
 * @property view the view the presenter is based on
 * @constructor Injects the required dependencies
 */
abstract class BasePresenter<out V : BaseView>(protected val view: V) {

    /**
     * The injector used to inject required dependencies
     */
    private val injector: Injector = DaggerInjector
        .builder()
        .baseView(view)
        .contextModule(ContextModule)
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * This method may be called when the view is created
     */
    open fun onViewCreated(){}

    /**
     * This method may be called when the view is destroyed
     */
    open fun onViewDestroyed(){}

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when(this){
            is CategoriesPresenter -> injector.inject(this)
        }
    }

}