package com.somethingsimple.publicapichooser.ui.api.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.somethingsimple.publicapichooser.R
import com.somethingsimple.publicapichooser.data.vo.ApiEntry
import com.somethingsimple.publicapichooser.databinding.FragmentApiDetailsBinding
import com.somethingsimple.publicapichooser.ui.ApiChooserScreens
import com.somethingsimple.publicapichooser.ui.common.BackButtonListener
import com.somethingsimple.publicapichooser.ui.common.BaseFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

private const val ARG_API_ID = "api_id"

class ApiDetailsFragment : BaseFragment(R.layout.fragment_api_details), ApiDetailsView,
    BackButtonListener {

    private var viewBinding: FragmentApiDetailsBinding? = null

    val apiId: Long by lazy {
        arguments?.getLong(ARG_API_ID) ?: 0L
    }

    @Inject
    lateinit var apiDetailsPresenterFactory: ApiDetailsPresenterFactory

    private val presenter: ApiDetailsPresenter by moxyPresenter {
        apiDetailsPresenterFactory.create(apiId, ApiChooserScreens)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentApiDetailsBinding.inflate(inflater, container, false)
        .apply {
            viewBinding = this
        }
        .root

    companion object {

        fun newInstance(id: Long) =
            ApiDetailsFragment().apply {
                arguments = Bundle().apply {
                    putLong(ARG_API_ID, id)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    override fun init() {
        TODO("Not yet implemented")
    }

    override fun showDetails(apiEntry: ApiEntry) {
        viewBinding?.apply {
            apiCategory.text = apiEntry.category
            apiAuth.text = apiEntry.auth
            apiDescription.text = apiEntry.description
            apiName.text = apiEntry.api
            apiUrl.text = apiEntry.link
        }
    }

    override fun showError(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun backPressed(): Boolean = presenter.backPressed()
}