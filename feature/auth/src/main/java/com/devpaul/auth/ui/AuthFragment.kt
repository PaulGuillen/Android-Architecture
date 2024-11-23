package com.devpaul.auth.ui

import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import com.devpaul.auth.databinding.FragmentAuthBinding
import com.devpaul.core_platform.activity.LoadingActivity
import com.devpaul.core_platform.activity.setToolbarMode
import com.devpaul.core_platform.activity.showLoading
import com.devpaul.core_platform.entity.ToolbarMode
import com.devpaul.core_platform.fragment.ViewFragment
import com.devpaul.core_platform.fragment.base.OnBackPressedFragment
import com.devpaul.core_platform.fragment.createViewModel
import com.devpaul.core_platform.fragment.onUiState
import kotlinx.coroutines.launch
import timber.log.Timber

class AuthFragment : ViewFragment.Stateful<FragmentAuthBinding, AuthViewModel>(),
    OnBackPressedFragment {

    override fun getViewModel() = createViewModel<AuthViewModel>()
    override fun getViewBinding(inflater: LayoutInflater) =
        FragmentAuthBinding.inflate(inflater)

    override fun onInit() {

        setToolbarMode(ToolbarMode.Visible("AuthFragment", true))

        onUiState {

        }

        onUiState{

        }

        lifecycleScope.launch {
            viewModel.onLoading { isLoading ->
                Timber.d("AuthFragment - onLoading triggered: $isLoading")
                (activity as? LoadingActivity)?.isLoading = isLoading
            }
        }
    }

}