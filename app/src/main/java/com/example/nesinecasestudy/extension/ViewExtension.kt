package com.example.nesinecasestudy.extension

import android.content.Context
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.nesinecasestudy.util.Constant.IMAGE_URL

fun ImageView.setImageUrl(context: Context, url: String?, progressBar: ProgressBar) {
    progressBar.isVisible = true
    Glide.with(context)
        .addDefaultRequestListener(object : RequestListener<Any> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Any>,
                isFirstResource: Boolean
            ): Boolean {
                progressBar.isVisible = false
                return false
            }

            override fun onResourceReady(
                resource: Any,
                model: Any,
                target: Target<Any>?,
                dataSource: DataSource,
                isFirstResource: Boolean
            ): Boolean {
                progressBar.isVisible = false
                return false
            }

        })
        .load(url).into(this)
}

fun ImageView.setImageFromPos(context: Context, pos: Int, progressBar: ProgressBar) {
    this.setImageUrl(context, getFullImageUrl(pos), progressBar)
}

fun getFullImageUrl(pos: Int): String {
    return "$IMAGE_URL${pos}&grayscale"
}

