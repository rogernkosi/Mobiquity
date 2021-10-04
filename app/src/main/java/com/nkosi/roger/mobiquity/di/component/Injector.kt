package com.nkosi.roger.mobiquity.di.component

import com.nkosi.roger.mobiquity.base.BaseView
import com.nkosi.roger.mobiquity.di.modules.ContextModule
import com.nkosi.roger.mobiquity.di.modules.NetworkModule
import com.nkosi.roger.mobiquity.ui.CategoriesPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [ContextModule::class, NetworkModule::class])
interface Injector {

    /**
     * Injects required dependencies into the specified CategoriesPresenter.
     * @param categoriesPresenter CategoriesPresenter in which to inject the dependencies
     */
    fun inject(categoriesPresenter: CategoriesPresenter)

    @Component.Builder
    interface Builder {
        fun build(): Injector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }

}