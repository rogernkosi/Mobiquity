package com.nkosi.roger.mobiquity.base

import com.nkosi.roger.mobiquity.network.CategoryApi

open class BaseInteractor(): MvpInteractor {
    protected lateinit var api: CategoryApi

    constructor(api: CategoryApi) : this() {
        this.api = api
    }
}