package com.somethingsimple.publicapichooser.ui.api.list

import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.publicapichooser.ui.common.ItemView

interface PublicApiItemView : ItemView {
    fun bind(apiEntry: ApiEntry)
}