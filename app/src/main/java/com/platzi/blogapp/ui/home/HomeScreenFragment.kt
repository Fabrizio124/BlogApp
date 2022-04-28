package com.platzi.blogapp.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.platzi.blogapp.R
import com.platzi.blogapp.core.Resource
import com.platzi.blogapp.data.model.remote.home.HomeScreenDataSource
import com.platzi.blogapp.databinding.FragmentHomeScreenBinding
import com.platzi.blogapp.domain.home.HomeScreenRepoImpl
import com.platzi.blogapp.presentation.HomeScreenViewModel
import com.platzi.blogapp.presentation.HomeScreenViewModelFactory
import com.platzi.blogapp.ui.home.adapter.HomeScreenAdapter


class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {

    private lateinit var binding: FragmentHomeScreenBinding
    private val viewModel by viewModels<HomeScreenViewModel>{ HomeScreenViewModelFactory(
        HomeScreenRepoImpl(
        HomeScreenDataSource()
    )
    ) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeScreenBinding.bind(view)

        viewModel.fetchLatestPost().observe(viewLifecycleOwner, Observer { result ->
          when(result) {
              is Resource.Loading -> {
                  binding.progressBar.visibility = View.VISIBLE
              }

              is Resource.Success -> {
                  binding.progressBar.visibility = View.GONE
                  binding.rvHome.adapter = HomeScreenAdapter(result.data)
              }

              is Resource.Failure -> {
                  binding.progressBar.visibility = View.GONE
                  Toast.makeText(
                      requireContext(),
                      "Ocurrio un error: ${result.exception}",
                      Toast.LENGTH_SHORT
                  ).show()
              }
          }
        })
    }
}