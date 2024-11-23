package com.devpaul.core_platform.fragment.base

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.appcompat.widget.Toolbar
import com.devpaul.core_platform.R


open class BaseFragment : DialogFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun setToolbarTitle(title: String) {
        val toolbar: Toolbar? = view?.findViewById(R.id.toolbar)
        val titleView: TextView? = toolbar?.findViewById(R.id.toolbar_title)
        titleView?.text = title
    }
}