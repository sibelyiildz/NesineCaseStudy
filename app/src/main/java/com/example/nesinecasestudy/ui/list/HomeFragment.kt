package com.example.nesinecasestudy.ui.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.example.nesinecasestudy.base.BaseFragment
import com.example.nesinecasestudy.data.remote.model.PostResponse
import com.example.nesinecasestudy.databinding.FragmentHomeBinding
import com.example.nesinecasestudy.extension.errorDialog
import com.example.nesinecasestudy.extension.linearDivider
import com.example.nesinecasestudy.util.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()
    private val adapter by lazy { PostsAdapter() }
    private val itemDecoration by lazy { linearDivider() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()

        viewModel.fetchPosts()
        viewModel.posts.observe(viewLifecycleOwner, ::postsObserver)
    }

    private fun postsObserver(response: UIState<List<PostResponse>>) {
        setLoading(response is UIState.Loading)
        when (response) {
            is UIState.Success -> {
                Log.v("LogTag", "Success -> ${response.data}")
                adapter.submitList(response.data)
            }

            is UIState.Error -> {
                errorDialog {
                    setMessage(response.error.message)
                }
                Log.v("LogTag", "Error -> ${response.error}")
            }

            is UIState.Loading -> {
                Log.v("LogTag", "Loading")
            }
        }
    }

    private fun initialize() {
        binding.postsRecyclerView.adapter = adapter
        binding.postsRecyclerView.addItemDecoration(itemDecoration)
    }


}