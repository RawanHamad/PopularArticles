package com.example.populararticles.base

import android.os.Bundle


abstract class BaseFragmentActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
    }

    abstract fun fragment(): BaseFragment

    abstract fun getLayout(): Int
}