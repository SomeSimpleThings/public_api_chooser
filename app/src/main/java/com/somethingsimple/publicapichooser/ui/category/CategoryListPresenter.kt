package com.somethingsimple.publicapichooser.ui.category

import com.somethingsimple.publicapichooser.data.vo.Category
import com.somethingsimple.publicapichooser.ui.common.ListPresenter

class CategoryListPresenter : ListPresenter<CategoryItemView, Category> {

    val categories = mutableListOf<Category>()

    override fun addAll(newList: List<Category>) {
        categories.addAll(newList)
    }

    override var itemClickListener: ((CategoryItemView) -> Unit)? = null

    override fun getCount() = categories.size

    override fun getItemAtPos(pos: Int): Category? = categories.getOrNull(pos)

    override fun clear() = categories.clear()

    override fun bindView(view: CategoryItemView) {
        view.bind(categories[view.pos])
    }
}