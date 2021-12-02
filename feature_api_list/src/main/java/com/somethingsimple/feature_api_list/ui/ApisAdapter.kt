package com.somethingsimple.feature_api_list.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.feature_api_list.databinding.PublicapiItemBinding

class ApisAdapter(
    val apiClickCallback: (ApiEntry) -> Unit
) : ListAdapter<ApiEntry, RecyclerView.ViewHolder>(ApiEntryDiff()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            PublicapiItemBinding.inflate(
                LayoutInflater
                    .from(parent.context),
                parent,
                false
            )
        return ApiEntryViewHolder(binding, apiClickCallback)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ApiEntryViewHolder).bind(getItem(position))
    }

    inner class ApiEntryViewHolder(
        private val binding: PublicapiItemBinding,
        apiClickCallback: (ApiEntry) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener { apiClickCallback.invoke(getItem(layoutPosition)) }
        }

        fun bind(apiEntry: ApiEntry) {
            binding.apply {
                apiName.text = apiEntry.api
                apiDescription.text = apiEntry.description
                apiLink.text = apiEntry.link
                apiAuth.text = apiEntry.auth
            }
        }
    }

    class ApiEntryDiff : DiffUtil.ItemCallback<ApiEntry>() {
        override fun areItemsTheSame(oldItem: ApiEntry, newItem: ApiEntry): Boolean {
            return oldItem.api == newItem.api
        }

        override fun areContentsTheSame(oldItem: ApiEntry, newItem: ApiEntry): Boolean {
            return oldItem == newItem
        }
    }
}