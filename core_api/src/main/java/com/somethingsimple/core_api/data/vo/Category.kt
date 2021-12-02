package com.somethingsimple.core_api.data.vo

import com.somethingsimple.core_api.data.db.entity.CategorySynt

data class Category(val name: String) {

    constructor(category: CategorySynt) :
            this(category.categoryName)
}
