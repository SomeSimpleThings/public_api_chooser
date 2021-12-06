package com.somethingsimple.feature_categories.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.feature_categories.R
import com.somethingsimple.feature_categories.databinding.ApiEntryCardBinding

class ApisAdapter(
    val apiClickCallback: (ApiEntry) -> Unit
) : ListAdapter<ApiEntry, RecyclerView.ViewHolder>(ApisDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ApiEntryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ApiEntryViewHolder(binding, apiClickCallback)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ApiEntryViewHolder).bind(getItem(position))
    }

    inner class ApiEntryViewHolder(
        private val binding: ApiEntryCardBinding,
        apiClickCallback: (ApiEntry) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener { apiClickCallback.invoke(getItem(layoutPosition)) }
        }

        fun bind(item: ApiEntry) {
            binding.apiName.text = item.api
            binding.apiCard.setCardBackgroundColor(getColor(item.favourite))
        }

        private fun getColor(favourite: Boolean): Int {
            val color = if (favourite) R.color.green_background else R.color.blue_background
            return ContextCompat.getColor(itemView.context, color)
        }
    }

    class ApisDiffCallback : DiffUtil.ItemCallback<ApiEntry>() {
        override fun areItemsTheSame(oldItem: ApiEntry, newItem: ApiEntry): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ApiEntry, newItem: ApiEntry): Boolean {
            return oldItem == newItem
        }
    }
}