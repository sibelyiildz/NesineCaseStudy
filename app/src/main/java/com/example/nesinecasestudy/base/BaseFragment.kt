package com.example.nesinecasestudy.base

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.viewbinding.ViewBinding
import com.example.nesinecasestudy.R

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T
abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    private lateinit var progressBar: AlertDialog
    private val _showLoading = MutableLiveData<Boolean>()
    private val showLoading: LiveData<Boolean> = _showLoading

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoading.observe(viewLifecycleOwner) {
            if (it) {
                showProgress()
            } else {
                hideProgress()
            }
        }
    }

    private fun showProgress() {
        if (!(::progressBar.isInitialized)) {
            val dialog = AlertDialog.Builder(requireContext())
            val view = layoutInflater.inflate(R.layout.progress_layout, null)
            dialog.setView(view)
            dialog.setCancelable(false)
            progressBar = dialog.create()
            progressBar.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }
        progressBar.show()
    }

    private fun hideProgress() {
        if (::progressBar.isInitialized) {
            progressBar.hide()
        }
    }

    fun setLoading(isLoading: Boolean) {
        _showLoading.value = isLoading
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}