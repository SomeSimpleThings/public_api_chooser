package com.somethingsimple.feature_categories.domain

import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.data.vo.Category

data class CategoryWithEntries(val category: Category, val entries: List<ApiEntry>)
