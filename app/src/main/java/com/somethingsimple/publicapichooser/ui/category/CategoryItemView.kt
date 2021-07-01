package com.somethingsimple.publicapichooser.ui.category

import com.somethingsimple.publicapichooser.data.vo.Category
import com.somethingsimple.publicapichooser.ui.common.ItemView

interface CategoryItemView : ItemView {
    fun bind(category: Category)
}