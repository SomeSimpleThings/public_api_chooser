package com.somethingsimple.feature_api_list.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.somethingsimple.core_api.di.provider.AppWithComponent
import com.somethingsimple.core_api.ui.common.BackButtonListener
import com.somethingsimple.feature_api_list.R
import com.somethingsimple.feature_api_list.databinding.FragmentApisBinding
import com.somethingsimple.feature_api_list.di.ApiListComponent
import javax.inject.Inject

private const val ARG_CATEGORY = "category_name"


class ApisFragment : Fragment(R.layout.fragment_apis),
    BackButtonListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val apisViewModel: ApisViewModel by viewModels {
        viewModelFactory
    }

    private var viewBinding: FragmentApisBinding? = null

    val category: String by lazy {
        arguments?.getString(ARG_CATEGORY) ?: ""
    }

    private var apisAdapter: ApisAdapter? = null

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
            viewBinding?.recyclerApis?.apply {
                apisAdapter = ApisAdapter {
                    findNavController().navigate(
                        R.id.action_to_api_details,
                        Bundle().apply { putString("api_id", it.link) })
                }
                this.adapter = apisAdapter
                this.layoutManager = LinearLayoutManager(context)
            }
        }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        apisViewModel.getApisForCategory(category)
        apisViewModel.apiLiveData.observe(viewLifecycleOwner, { list ->
            apisAdapter?.submitList(list)
        })

    }

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


