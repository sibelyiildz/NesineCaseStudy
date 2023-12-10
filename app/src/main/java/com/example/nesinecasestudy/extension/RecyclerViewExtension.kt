package com.example.nesinecasestudy.extension

import android.graphics.drawable.InsetDrawable
import androidx.annotation.DimenRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration


fun Fragment.linearDivider(
    isHorizontal: Boolean = false,
    @DimenRes margin: Int? = null,
): DividerItemDecoration {
    val itemDecoration = DividerItemDecoration(
        requireContext(),
        if (isHorizontal) DividerItemDecoration.HORIZONTAL else DividerItemDecoration.VERTICAL
    )
    margin?.let {
        val inset = resources.getDimensionPixelSize(it)
        val insetDivider = InsetDrawable(
            itemDecoration.drawable,
            if (isHorizontal) 0 else inset,
            if (isHorizontal) inset else 0,
            if (isHorizontal) 0 else inset,
            if (isHorizontal) inset else 0
        )
        itemDecoration.setDrawable(insetDivider)
    }
    return itemDecoration
}