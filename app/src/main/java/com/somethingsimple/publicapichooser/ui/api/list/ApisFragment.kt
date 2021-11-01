package com.somethingsimple.publicapichooser.ui.api.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.somethingsimple.publicapichooser.R
import com.somethingsimple.publicapichooser.databinding.FragmentApisBinding
import com.somethingsimple.publicapichooser.ui.ApiChooserScreens
import com.somethingsimple.publicapichooser.ui.common.BackButtonListener
import com.somethingsimple.publicapichooser.ui.common.BaseFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

private const val ARG_CATEGORY = "category_name"


class ApisFragment : BaseFragment(R.layout.fragment_apis),
    PublicApisView,
    BackButtonListener {

    private var viewBinding: FragmentApisBinding? = null

    val category: String by lazy {
        arguments?.getString(ARG_CATEGORY) ?: ""
    }

    @Inject
    lateinit var apisPresenterFactory: PublicApisPresenterFactory

    private var adapter: PublicApisAdapter? = null
    private val presenter: PublicApisPresenter by moxyPresenter {
        apisPresenterFactory.create(category, ApiChooserScreens)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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


