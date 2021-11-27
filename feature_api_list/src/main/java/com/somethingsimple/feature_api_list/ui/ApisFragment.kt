package com.somethingsimple.feature_api_list.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.somethingsimple.core_api.di.provider.AppWithComponent
import com.somethingsimple.core_api.ui.common.BackButtonListener
import com.somethingsimple.feature_api_list.R
import com.somethingsimple.feature_api_list.databinding.FragmentApisBinding
import com.somethingsimple.feature_api_list.di.ApiListComponent

private const val ARG_CATEGORY = "category_name"


class ApisFragment : Fragment(R.layout.fragment_apis),
    BackButtonListener {

    private var viewBinding: FragmentApisBinding? = null

    val category: String by lazy {
        arguments?.getString(ARG_CATEGORY) ?: ""
    }

//    private var adapter: PublicApisAdapter? = null

    override fun onAttach(context: Context) {
        ApiListComponent
            .create(
                (requireActivity().application as AppWithComponent)
                    .getComponent()
            )
            .inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentApisBinding.inflate(inflater, container, false)
        .apply {
            viewBinding = this
        }
        .root

    companion object {
        @JvmStatic
        fun newInstance(name: String) = ApisFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_CATEGORY, name)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }


    override fun backPressed(): Boolean = true
}


