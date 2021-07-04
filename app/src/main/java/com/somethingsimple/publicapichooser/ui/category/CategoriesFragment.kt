package com.somethingsimple.publicapichooser.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.terrakok.cicerone.Router
import com.somethingsimple.publicapichooser.R
import com.somethingsimple.publicapichooser.data.repository.category.CategoryRepository
import com.somethingsimple.publicapichooser.databinding.FragmentCategoriesBinding
import com.somethingsimple.publicapichooser.schedulers.Schedulers
import com.somethingsimple.publicapichooser.ui.common.BackButtonListener
import com.somethingsimple.publicapichooser.ui.common.BaseFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject


class CategoriesFragment : BaseFragment(R.layout.fragment_categories),
    CategoriesView,
    BackButtonListener {

    private var viewBinding: FragmentCategoriesBinding? = null

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var categoryRepository: CategoryRepository

    @Inject
    lateinit var schedulers: Schedulers


    private var adapter: CategoriesAdapter? = null
    private val presenter: CategoriesPresenter by moxyPresenter {
        CategoriesPresenter(
            categoryRepository,
            router,
            schedulers
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentCategoriesBinding.inflate(inflater, container, false)
        .apply {
            viewBinding = this
        }
        .root

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = CategoriesFragment()
    }

    override fun init() {
        adapter = CategoriesAdapter(presenter.categoryListPresenter)
        viewBinding?.rvCategories?.also {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = adapter
        }

    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun addItemToList(position: Int) {
        adapter?.notifyItemInserted(position)
    }

    override fun loadingError(text: String?) {
//        TODO("Not yet implemented")
    }

    override fun backPressed() = presenter.backPressed()
}