package com.sandisetiawan444.base.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

open class BaseViewModel(
    private val mDispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel(), CoroutineScope {

    protected val _showProgress = MutableLiveData<Boolean>()
    val showProgress: LiveData<Boolean> = Transformations.map(_showProgress) { it }

    protected val _message = MutableLiveData<String>()
    val message: LiveData<String> = Transformations.map(_message) { it }

    override val coroutineContext: CoroutineContext
        get() = mDispatcher + SupervisorJob()
}