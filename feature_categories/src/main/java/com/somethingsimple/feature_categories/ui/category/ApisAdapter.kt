package com.somethingsimple.feature_categories.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.feature_categories.databinding.ApiEntryCardBinding

class ApisAdapter() : ListAdapter<ApiEntry, RecyclerView.ViewHolder>(ApisDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ApiEntryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ApiEntryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ApiEntryViewHolder).bind(getItem(position))
    }

    inner class ApiEntryViewHolder(private val binding: ApiEntryCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ApiEntry) {
            binding.apiName.text = item.api
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