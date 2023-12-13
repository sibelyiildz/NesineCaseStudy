package com.example.nesinecasestudy.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.nesinecasestudy.R
import com.example.nesinecasestudy.base.BaseFragment
import com.example.nesinecasestudy.databinding.FragmentPostDetailBinding
import com.example.nesinecasestudy.extension.errorDialog
import com.example.nesinecasestudy.extension.setImageUrl
import com.example.nesinecasestudy.util.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailFragment :
    BaseFragment<FragmentPostDetailBinding>(FragmentPostDetailBinding::inflate) {

    companion object {
        private const val POST_UPDATE = "post_update"
        fun setFragmentResultListener(
            fragment: Fragment, block: () -> Unit
        ) {
            fragment.setFragmentResultListener(POST_UPDATE) { _, _ ->
                block.invoke()
            }
        }
    }

    private val viewModel: PostDetailViewModel by viewModels()
    private val args by navArgs<PostDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()

        viewModel.updatePost.observe(viewLifecycleOwner, ::updatePostObserver)
    }

    private fun updatePostObserver(response: UIState<Unit>) {
        setLoading(response is UIState.Loading)
        when (response) {
            is UIState.Success -> {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.post_updated),
                    Toast.LENGTH_SHORT
                ).show()
                setFragmentResult(POST_UPDATE, bundleOf())
                findNavController().popBackStack()
            }

            is UIState.Error -> {
                errorDialog {
                    setMessage(response.error.message)
                }
            }

            UIState.Loading -> {}
        }
    }

    private fun setupUI() {
        with(binding) {
            image.setImageUrl(requireContext(), args.postResponse.imageUrl)
            title.setText(args.postResponse.title)
            desc.setText(args.postResponse.body)

            updateButton.setOnClickListener {
                viewModel.updatePostTitleAndBody(
                    args.postResponse.id, title.text.toString(), desc.text.toString()
                )
            }
        }
    }

}