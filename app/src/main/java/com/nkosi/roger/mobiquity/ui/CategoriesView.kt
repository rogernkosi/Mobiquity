package com.nkosi.roger.mobiquity.ui

import androidx.annotation.StringRes
import com.nkosi.roger.mobiquity.base.BaseView
import com.nkosi.roger.mobiquity.model.Category

interface CategoriesView: BaseView {

    /**
     * Updates the ui with the new categories
     * @param posts the list of categories that will replace existing ones
     */
    fun showCategories(posts: List<Category>)

    /**
     * Displays an error in the view
     * @param error the error to display in the view
     */
    fun showError(error: String)

    /**
     * Displays an error in the view
     * @param errorResId the resource id of the error to display in the view
     */
    fun showError(@StringRes errorResId: Int){
        this.showError(getContext().getString(errorResId))
    }

    /**
     * Displays the loading indicator of the view
     */
    fun showLoading()

    /**
     * Hides the loading indicator of the view
     */
    fun hideLoading()

}