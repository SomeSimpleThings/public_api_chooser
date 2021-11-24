package com.somethingsimple.publicapichooser.ui.api.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.publicapichooser.databinding.PublicapiItemBinding

class PublicApisAdapter(val presenter: PublicApiListPresenter) :
    RecyclerView.Adapter<PublicApisAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            PublicapiItemBinding.inflate(
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

    inner class ViewHolder(val binding: PublicapiItemBinding) :
        RecyclerView.ViewHolder(binding.root),
        PublicApiItemView {
        override fun bind(apiEntry: ApiEntry) {
            with(binding) {
                apiName.text = apiEntry.api
                apiDescription.text = apiEntry.description
                apiAuth.text = apiEntry.auth
            }
        }

        override var pos = -1

    }
}