package com.devpaul.auth.ui

import android.view.LayoutInflater
import com.devpaul.auth.databinding.FragmentAuthBinding
import com.devpaul.core_platform.activity.setToolbarMode
import com.devpaul.core_platform.entity.ToolbarMode
import com.devpaul.core_platform.fragment.ViewFragment
import com.devpaul.core_platform.fragment.base.OnBackPressedFragment
import com.devpaul.core_platform.fragment.createViewModel
import com.devpaul.core_platform.fragment.onUiState

class AuthFragment : ViewFragment.Stateful<FragmentAuthBinding, AuthViewModel>(),
    OnBackPressedFragment {

    override fun getViewModel() = createViewModel<AuthViewModel>()
    override fun getViewBinding(inflater: LayoutInflater) =
        FragmentAuthBinding.inflate(inflater)

    override fun onInit() {

        setToolbarMode(ToolbarMode.Visible("AuthFragment", true))

    }

}