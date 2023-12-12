package com.example.nesinecasestudy.ui.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.nesinecasestudy.R
import com.example.nesinecasestudy.base.BaseFragment
import com.example.nesinecasestudy.data.remote.model.PostResponse
import com.example.nesinecasestudy.databinding.FragmentHomeBinding
import com.example.nesinecasestudy.extension.attach
import com.example.nesinecasestudy.extension.detach
import com.example.nesinecasestudy.extension.dialog
import com.example.nesinecasestudy.extension.errorDialog
import com.example.nesinecasestudy.extension.linearDivider
import com.example.nesinecasestudy.util.SwipeToDeleteCallback
import com.example.nesinecasestudy.util.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()
    private val adapter by lazy { PostsAdapter() }
    private val itemDecoration by lazy { linearDivider() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewInitialize()

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

    private fun recyclerViewInitialize() {
        binding.postsRecyclerView.attach(adapter, itemDecoration)

        val swipeToDeleteCallback = object : SwipeToDeleteCallback(
            ContextCompat.getDrawable(requireContext(), R.drawable.vc_delete)
        ) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                dialog {
                    setTitle(getString(R.string.warning))
                    setMessage(getString(R.string.post_delete_message))
                    setPositiveButton(getString(R.string.yes)) { _, _ ->
                        adapter.deleteItem(viewHolder.adapterPosition)
                    }
                    setNegativeButton(getString(R.string.no)) { _, _ ->
                        adapter.notifyItemChanged(viewHolder.adapterPosition)
                    }
                }
            }

        }
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(binding.postsRecyclerView)

    }

    override fun onDestroyView() {
        binding.postsRecyclerView.detach()
        super.onDestroyView()
    }


}