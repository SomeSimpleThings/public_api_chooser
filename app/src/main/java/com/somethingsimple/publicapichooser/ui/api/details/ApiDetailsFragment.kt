package com.somethingsimple.publicapichooser.ui.api.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.somethingsimple.publicapichooser.R
import com.somethingsimple.publicapichooser.databinding.FragmentApiDetailsBinding
import com.somethingsimple.publicapichooser.ui.common.BackButtonListener

private const val ARG_API_ID = "api_id"

class ApiDetailsFragment : Fragment(R.layout.fragment_api_details),
    BackButtonListener {

    private var viewBinding: FragmentApiDetailsBinding? = null

    val api: String by lazy {
        arguments?.getString(ARG_API_ID) ?: ""
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