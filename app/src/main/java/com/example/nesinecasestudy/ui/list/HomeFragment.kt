package com.example.nesinecasestudy.ui.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.example.nesinecasestudy.base.BaseFragment
import com.example.nesinecasestudy.databinding.FragmentHomeBinding
import com.example.nesinecasestudy.util.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchPosts()
        viewModel.posts.observe(viewLifecycleOwner) {
            when (it) {
                is UIState.Error -> {
                    Log.v("LogTag", "Error -> ${it.error}")
                }

                is UIState.Loading -> {
                    Log.v("LogTag", "Loading")
                }

                is UIState.Success -> {
                    Log.v("LogTag", "Success -> ${it.data}")
                }
            }
        }
    }

}