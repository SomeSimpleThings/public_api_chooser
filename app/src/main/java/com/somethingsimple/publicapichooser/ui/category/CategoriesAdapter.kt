package com.somethingsimple.publicapichooser.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.somethingsimple.publicapichooser.data.vo.Category
import com.somethingsimple.publicapichooser.databinding.CategoryItemBinding
import com.somethingsimple.publicapichooser.ui.common.ListPresenter

class CategoriesAdapter(val presenter: ListPresenter<CategoryItemView, Category>) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            CategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    inner class ViewHolder(val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root),
        CategoryItemView {
        override fun bind(category: Category) {
            with(binding) {
                categoryName.text = category.name
            }
        }

        override var pos = -1

    }
}
