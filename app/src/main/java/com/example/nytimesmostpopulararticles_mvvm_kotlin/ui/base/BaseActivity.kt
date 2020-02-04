package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base

import android.annotation.TargetApi
import android.app.ProgressDialog
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.CommonUtils.showLoadingDialog
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.NetworkUtils.isNetworkConnected
import dagger.android.AndroidInjection

abstract class BaseActivity<T : ViewDataBinding?, V : BaseViewModel<*>?> :
    AppCompatActivity(), BaseFragment.Callback {
    // TODO
// this can probably depend on isLoading variable of BaseViewModel,
// since its going to be common for all the activities
    private var mProgressDialog: ProgressDialog? = null
    private var viewDataBinding: T? = null
    private var mViewModel: V? = null
    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    abstract val bindingVariable: Int

    /**
     * @return layout resource id
     */
    @get:LayoutRes
    abstract val layoutId: Int

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract val viewModel: V

    override fun onFragmentAttached() {}
    override fun onFragmentDetached(tag: String?) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String?): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                permission?.let { checkSelfPermission(it) } == PackageManager.PERMISSION_GRANTED
    }

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog?.cancel()
        }
    }

    val isNetworkConnected: Boolean
        get() = isNetworkConnected(
            applicationContext
        )

    fun openActivityOnTokenExpire() { //        startActivity(LoginActivity.newIntent(this));
        finish()
    }

    fun getViewDataBinding(): T? {
        return viewDataBinding
    }

    fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(
        permissions: Array<String?>?,
        requestCode: Int
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            permissions?.let { requestPermissions(it, requestCode) }
        }
    }

    fun showLoading() {
        hideLoading()
        mProgressDialog = showLoadingDialog(this)
    }

    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView<T>(this, layoutId)
        mViewModel = if (mViewModel == null) viewModel else mViewModel
        viewDataBinding?.setVariable(bindingVariable, mViewModel)
        viewDataBinding?.executePendingBindings()
    }
}