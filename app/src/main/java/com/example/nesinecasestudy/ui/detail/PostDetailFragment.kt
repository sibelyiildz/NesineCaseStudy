package com.example.nesinecasestudy.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.nesinecasestudy.base.BaseFragment
import com.example.nesinecasestudy.databinding.FragmentPostDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailFragment :
    BaseFragment<FragmentPostDetailBinding>(FragmentPostDetailBinding::inflate) {

    private val viewModel: PostDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}