package com.somethingsimple.publicapichooser.ui.api

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.terrakok.cicerone.Router
import com.somethingsimple.publicapichooser.R
import com.somethingsimple.publicapichooser.data.repository.publicapi.PublicApiRepository
import com.somethingsimple.publicapichooser.databinding.FragmentApisBinding
import com.somethingsimple.publicapichooser.schedulers.Schedulers
import com.somethingsimple.publicapichooser.ui.common.BackButtonListener
import com.somethingsimple.publicapichooser.ui.common.BaseFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

private const val ARG_CATEGORY = "category_name"


class ApisFragment : BaseFragment(R.layout.fragment_apis),
    PublicApisView,
    BackButtonListener {

    private var viewBinding: FragmentApisBinding? = null

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var apiRepository: PublicApiRepository

    @Inject
    lateinit var schedulers: Schedulers

    private var adapter: PublicApisAdapter? = null
    private val presenter: PublicApisPresenter by moxyPresenter {
        PublicApisPresenter(
            apiRepository,
            router,
            schedulers
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val categoryName: String? = it.getString(ARG_CATEGORY)
            presenter.getApisForCategory(categoryName)
        }

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

    override fun init() {
        adapter = PublicApisAdapter(presenter.apiListPresenter)
        viewBinding?.rvApis?.also {
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
        Toast
            .makeText(context, "category not found", Toast.LENGTH_SHORT)
            .show()
    }

    override fun backPressed(): Boolean = presenter.backPressed()
}


