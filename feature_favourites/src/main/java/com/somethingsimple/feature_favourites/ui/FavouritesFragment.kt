package com.somethingsimple.feature_favourites.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.somethingsimple.core_api.di.provider.AppWithComponent
import com.somethingsimple.feature_api_list.databinding.FragmentApisBinding
import com.somethingsimple.feature_api_list.ui.ApisAdapter
import com.somethingsimple.feature_favourites.R
import com.somethingsimple.feature_favourites.di.FavouritesComponent
import javax.inject.Inject

class FavouritesFragment : Fragment(R.layout.fragment_apis) {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val favouritesViewModel: FavouritesViewModel by viewModels {
        viewModelFactory
    }

    private var viewBinding: FragmentApisBinding? = null


    private var apisAdapter: ApisAdapter? = null

    override fun onAttach(context: Context) {
        FavouritesComponent
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
        favouritesViewModel.getFavourites()
        favouritesViewModel.favouritesLiveData.observe(viewLifecycleOwner, { list ->
            apisAdapter?.submitList(list)
        })

    }

    companion object {
        @JvmStatic
        fun newInstance() = FavouritesFragment()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}