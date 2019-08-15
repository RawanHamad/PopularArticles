package com.example.populararticles.base

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.example.populararticles.di.module.Injectable
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * Base Fragment class with helper methods for handling views and back button events.
 *
 * @see Fragment
 */
abstract class BaseFragment : androidx.fragment.app.Fragment(), Injectable {

    abstract fun layoutId(): Int

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    internal fun firstTimeCreated(savedInstanceState: Bundle?) = savedInstanceState == null

    open fun onBackPressed() {}

    internal fun showProgress() = progressStatus(View.VISIBLE)

    internal fun hideProgress() = progressStatus(View.GONE)

    private fun progressStatus(viewStatus: Int) =
        with(activity) { if (this is BaseActivity) this.progress.visibility = viewStatus }

    internal open fun notifyWithAction(@StringRes message: Int, @StringRes actionText: Int, action: () -> Any) {
        Toast.makeText(context,message,Toast.LENGTH_LONG).show()
    }



}