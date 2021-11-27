package com.somethingsimple.feature_api_details.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.somethingsimple.core_api.di.provider.AppWithComponent
import com.somethingsimple.core_api.ui.common.BackButtonListener
import com.somethingsimple.feature_api_details.R
import com.somethingsimple.feature_api_details.databinding.FragmentApiDetailsBinding
import com.somethingsimple.feature_api_details.di.ApiDetailsComponent
import javax.inject.Inject

private const val ARG_API_ID = "api_id"

class ApiDetailsFragment : Fragment(R.layout.fragment_api_details),
    BackButtonListener {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    val apiDetailsViewModel: ApiDetailsViewModel by viewModels { factory }

    private var viewBinding: FragmentApiDetailsBinding? = null

    val api: String by lazy {
        arguments?.getString(ARG_API_ID) ?: ""
    }

    override fun onAttach(context: Context) {
        ApiDetailsComponent
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
    ): View = FragmentApiDetailsBinding.inflate(inflater, container, false)
        .apply {
            viewBinding = this
        }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        apiDetailsViewModel.getApi(api)
        apiDetailsViewModel.liveData.observe(viewLifecycleOwner) {
            viewBinding?.apiName?.text = it.toString()

        }
    }

    companion object {

        fun newInstance(api: String) =
            ApiDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_API_ID, api)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    override fun backPressed(): Boolean = true
}