package com.example.kotlinmvvmmultidadabindingconcept.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class DaggerViewModelFactory
@Inject constructor(private val creaters:Map<Class<out ViewModel>,@JvmSuppressWildcards Provider<ViewModel>>):ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CASE")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creater:Provider<ViewModel>?=creaters[modelClass]
        if(creater==null)
            for ((key,value)in creaters)
            {
                if(modelClass.isAssignableFrom(key))
                {
                    creater=value
                    break
                }
            }
        if(creater==null)throw IllegalArgumentException("Unknown class model")
        try {
            return  creater.get() as T
        }catch (e:Exception){
            throw  RuntimeException(e)
        }
    }
}