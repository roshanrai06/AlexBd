package com.roshan.alexbd.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.roshan.alexbd.ui.OnFragmentInteractionListener
import com.roshan.alexbd.R
import com.roshan.alexbd.ui.ListState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var fragmentListener: OnFragmentInteractionListener
    lateinit var loader: ProgressBar


    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            fragmentListener = context as OnFragmentInteractionListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString()
                    .toString() + " must implement LogoutUser"
            )
        }
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        val imageView = view.findViewById<ImageView>(R.id.imageViewLeftTop)
        loader = view.findViewById<ProgressBar>(R.id.progressBar)
        imageView.setOnClickListener {
            viewModel.makeBirthdayListAPICall()
            loader.visibility = View.VISIBLE
            viewModel.birthdayListLiveData.observe(viewLifecycleOwner, {})
            // fragmentListener.onButtonClick()
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        initObservers()

    }

    private fun initObservers() {
        viewModel.listState.observe(viewLifecycleOwner) { state ->
            handleUIState(state)
        }
    }

    private fun handleUIState(state: ListState?) {
        when (state) {
            is ListState.Loading -> {
                loader.isVisible = true
            }
            is ListState.Loaded -> {
                loader.isVisible = true
            }

            is ListState.Error -> {
                // displayError()
            }
            ListState.Empty -> {
                //displayError(getString(R.string.no_result))
            }

        }
    }

}