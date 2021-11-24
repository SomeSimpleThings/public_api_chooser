package com.somethingsimple.publicapichooser.ui.category

import com.somethingsimple.core_api.data.vo.Category
import com.somethingsimple.publicapichooser.ui.common.ItemView

interface CategoryItemView : ItemView {
    fun bind(category: Category)
}