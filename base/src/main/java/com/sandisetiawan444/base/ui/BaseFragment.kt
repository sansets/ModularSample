package com.sandisetiawan444.base.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.sandisetiawan444.base.ext.showToast

abstract class BaseFragment<T : BaseViewModel> : Fragment() {

    private var mViewModel: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateInjector()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mViewModel = getViewModel()?.apply {
            message.observe(viewLifecycleOwner, Observer {
                showToast(it)
            })
        }
    }

    abstract fun onCreateInjector()
    abstract fun getViewModel(): T?
}