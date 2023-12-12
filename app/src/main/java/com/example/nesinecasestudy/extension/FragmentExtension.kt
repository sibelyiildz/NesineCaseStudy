package com.example.nesinecasestudy.extension

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.nesinecasestudy.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun Fragment.dialog(
    block: MaterialAlertDialogBuilder.() -> Unit,
) {
    val builder = MaterialAlertDialogBuilder(requireContext())
    block.invoke(builder)
    builder.show()
}

fun Fragment.errorDialog(
    block: MaterialAlertDialogBuilder.() -> Unit,
) {
    this.dialog {
        setTitle(this.context.getString(R.string.error))
        setCancelable(true)
        setPositiveButton(this.context.getString(R.string.okay)) { _, _ -> }
        block.invoke(this)
    }
}

fun  Fragment.getDrawable(@DrawableRes drawableId: Int): Drawable? {
   return ContextCompat.getDrawable(requireContext(), drawableId)
}