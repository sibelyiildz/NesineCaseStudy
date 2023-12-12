package com.example.nesinecasestudy.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.nesinecasestudy.base.BaseFragment
import com.example.nesinecasestudy.databinding.FragmentPostDetailBinding
import com.example.nesinecasestudy.extension.setImageUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailFragment :
    BaseFragment<FragmentPostDetailBinding>(FragmentPostDetailBinding::inflate) {

    private val viewModel: PostDetailViewModel by viewModels()
    private val args by navArgs<PostDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
    }

    private fun setupUI() {
        with(binding) {
            image.setImageUrl(requireContext(), args.postResponse.imageUrl)
            title.text = args.postResponse.title
            desc.text = args.postResponse.body
        }
    }

}