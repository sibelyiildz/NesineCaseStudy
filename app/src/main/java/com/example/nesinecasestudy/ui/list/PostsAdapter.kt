package com.example.nesinecasestudy.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nesinecasestudy.NavGraphDirections
import com.example.nesinecasestudy.databinding.ListItemPostBinding
import com.example.nesinecasestudy.domain.model.PostModel
import com.example.nesinecasestudy.extension.setImageUrl

class PostsAdapter : ListAdapter<PostModel, PostsAdapter.ViewHolder>(DIFF) {
    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<PostModel>() {
            override fun areItemsTheSame(oldItem: PostModel, newItem: PostModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: PostModel, newItem: PostModel): Boolean {
                return oldItem.title == newItem.title &&
                        oldItem.body == newItem.body
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemPostBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(currentList[position])
    }

    inner class ViewHolder(private val binding: ListItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: PostModel) {
            with(binding) {
                image.setImageUrl(root.context, data.imageUrl, progressBar)
                title.text = data.title
                desc.text = data.body
                root.setOnClickListener {
                    it.findNavController()
                        .navigate(NavGraphDirections.actionPostDetailFragment(data))
                }
            }
        }

    }


}