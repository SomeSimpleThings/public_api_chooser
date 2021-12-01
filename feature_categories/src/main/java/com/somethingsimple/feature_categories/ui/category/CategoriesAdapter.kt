package com.somethingsimple.feature_categories.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.somethingsimple.feature_categories.databinding.CategoryItemBinding
import com.somethingsimple.feature_categories.domain.CategoryWithEntries

class CategoriesAdapter(
    val categoryClickListener: (CategoryWithEntries) -> Unit
) :
    ListAdapter<CategoryWithEntries, RecyclerView.ViewHolder>(CategoryWithEntriesItemDiff()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            CategoryItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryWithEntriesViewHolder(binding, categoryClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CategoryWithEntriesViewHolder).bind(getItem(position))
    }


    inner class CategoryWithEntriesViewHolder(
        private val binding: CategoryItemBinding,
        categoryClickListener: (CategoryWithEntries) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener { categoryClickListener.invoke(getItem(layoutPosition)) }
        }

        fun bind(item: CategoryWithEntries) {
            binding.let {
                it.categoryName.text = item.category.name
                val adapter = ApisAdapter()
                it.recyclerApis.adapter = adapter
                adapter.submitList(item.entries)
            }
        }
    }

    class CategoryWithEntriesItemDiff : DiffUtil.ItemCallback<CategoryWithEntries>() {
        override fun areItemsTheSame(
            oldItem: CategoryWithEntries,
            newItem: CategoryWithEntries
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: CategoryWithEntries,
            newItem: CategoryWithEntries
        ): Boolean {
            return oldItem.entries == newItem.entries
        }
    }

}