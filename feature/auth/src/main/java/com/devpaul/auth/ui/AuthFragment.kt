package com.devpaul.auth.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devpaul.auth.R
import com.devpaul.core_platform.activity.setToolbarMode
import com.devpaul.core_platform.entity.ToolbarMode
import com.devpaul.navigation.MainGraph

class AuthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setToolbarMode(ToolbarMode.Visible("Auth"))
        return inflater.inflate(R.layout.fragment_auth, container, false)
    }

}