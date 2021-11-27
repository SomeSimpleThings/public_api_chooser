package com.somethingsimple.core_api.data.vo

import com.somethingsimple.core_api.data.db.entity.CategoryEntity
import com.somethingsimple.core_api.data.network.dto.CategoryDto

data class Category(val name: String) {

    constructor(category: CategoryEntity) :
            this(category.name)

    constructor(categoryDto: CategoryDto) :
            this(categoryDto.name)
}
