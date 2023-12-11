package com.example.nesinecasestudy.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nesinecasestudy.data.remote.model.PostResponse
import com.example.nesinecasestudy.databinding.ListItemPostBinding
import com.example.nesinecasestudy.extension.setImageFromPos

class PostsAdapter() : ListAdapter<PostResponse, PostsAdapter.ViewHolder>(DIFF) {
    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<PostResponse>() {
            override fun areItemsTheSame(oldItem: PostResponse, newItem: PostResponse): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: PostResponse, newItem: PostResponse): Boolean {
                return oldItem == newItem
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

    // TODO: Başka  bir çözüm  düşün
    fun deleteItem(pos: Int) {
        // currentList.removeAt(pos)
        //notifyItemRemoved(pos)
        val newList = ArrayList<PostResponse>()
        newList.addAll(currentList)
        newList.removeAt(pos)
        submitList(newList)
    }

    inner class ViewHolder(private val binding: ListItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: PostResponse) {
            with(binding) {
                image.setImageFromPos(binding.root.context, adapterPosition, binding.progressBar)
                title.text = data.title
                desc.text = data.body
            }
        }

    }


}