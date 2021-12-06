package com.somethingsimple.feature_categories.ui.category

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
import com.somethingsimple.feature_categories.R
import com.somethingsimple.feature_categories.databinding.FragmentCategoriesBinding
import com.somethingsimple.feature_categories.di.CategoryComponent
import javax.inject.Inject


class CategoriesFragment : Fragment(R.layout.fragment_categories) {

    private var viewBinding: FragmentCategoriesBinding? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    val categoryViewModel: CategoryViewModel by viewModels {
        factory
    }
    private var adapt: CategoriesAdapter? = null


    override fun onAttach(context: Context) {
        CategoryComponent
            .create((requireActivity().application as AppWithComponent).getComponent())
            .inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCategoriesBinding.inflate(inflater, container, false)
        .apply {
            viewBinding = this
            viewBinding?.recyclerCategories?.apply {
                adapt = CategoriesAdapter(
                    {
                        findNavController().navigate(
                            R.id.action_to_api_list,
                            Bundle().apply { putString("category_name", it.category.name) })
                    },
                    {
                        findNavController().navigate(
                            R.id.action_to_api_details,
                            Bundle().apply { putString("api_id", it.link) })
                    }
                )
                this.adapter = adapt
                this.layoutManager = LinearLayoutManager(context)
            }
        }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryViewModel.getCategories()

        categoryViewModel.apiLiveData.observe(viewLifecycleOwner, { list ->
            adapt?.submitList(list)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = CategoriesFragment()
    }
}