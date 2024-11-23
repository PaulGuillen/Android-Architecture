package com.telefonica.core_platform.fragment.base

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import com.google.android.material.snackbar.Snackbar
import com.telefonica.core_platform.fragment.onBackPressedCallback
import com.telefonica.core.R
import com.telefonica.core_platform.extension.appContext
import com.telefonica.core_platform.extension.viewContainer
import com.telefonica.core_platform.activity.setupActivityScaffold
import com.telefonica.core_platform.fragment.fullscreen
import com.telefonica.core_platform.fragment.isCancelable
import com.telefonica.core_platform.fragment.navigate
import com.telefonica.core_platform.fragment.isRootedSecondValidation
import com.telefonica.core_platform.ui.LoadingFragment
import com.telefonica.core_platform.ui.RootFragment
import com.telefonica.navigation.core.ModularDestination
import com.telefonica.navigation.core.navigateTo

abstract class AppFragment : Fragment(), FragmentScaffold {

    private val onBackPressedCallback by onBackPressedCallback()
    private var loadingFragment: LoadingFragment? = null
    private var isRooted = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupActivityScaffold()
        onBackPressedCallback?.isEnabled = true
        if (isRooted || isRootedSecondValidation()) {
            RootFragment().fullscreen().isCancelable(false).show()
        }
    }

    protected fun DialogFragment.show(tag: String? = null) {
        if (!isAdded) {
            this.show(this@AppFragment.childFragmentManager, tag)
        }
    }

    fun NavDirections.navigate() {
        this@AppFragment.navigate(this)
    }

    protected fun notify(@StringRes message: Int) =
        Snackbar.make(viewContainer, message, Snackbar.LENGTH_SHORT).show()

    protected fun notifyWithAction(
        @StringRes message: Int,
        @StringRes actionText: Int,
        action: () -> Any
    ) {
        val snackBar = Snackbar.make(viewContainer, message, Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction(actionText) { _ -> action.invoke() }
        snackBar.setActionTextColor(ContextCompat.getColor(appContext, R.color.colorTextPrimary))
        snackBar.show()
    }

    inline fun <reified T : Any> T.navigate(
        popUpToRoute: ModularDestination? = null,
        inclusive: Boolean = true,
    ) {
        navigateTo<T>(
            destination = this,
            popUpToRoute = popUpToRoute,
            inclusive = inclusive
        )
    }

    fun setLoading(isLoading: Boolean) {
        if (isLoading) {
            if (loadingFragment == null) {
                loadingFragment = LoadingFragment()
                loadingFragment?.show(childFragmentManager, LoadingFragment::class.java.simpleName)
            }
        } else {
            loadingFragment?.dismissAllowingStateLoss()
            loadingFragment = null
        }
    }

}