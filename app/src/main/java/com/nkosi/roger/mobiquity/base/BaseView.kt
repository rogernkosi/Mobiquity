package com.nkosi.roger.mobiquity.base

import android.content.Context

/**
 * To be implemented by all views.
 */
interface BaseView {
    /**
     * Returns the context in which the application is running.
     */
    fun getContext(): Context
}