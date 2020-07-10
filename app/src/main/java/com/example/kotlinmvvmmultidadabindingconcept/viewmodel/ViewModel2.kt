package com.example.kotlinmvvmmultidadabindingconcept.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmvvmmultidadabindingconcept.repositry.Repositry2
import javax.inject.Inject

class ViewModel2:ViewModel {
    @Inject
    constructor()
    var repositry2= Repositry2()
    var mutableLiveData= MutableLiveData<String>()
    fun  callData()
    {
        repositry2.getMutableData()
    }
    fun  getMutableDataString(): MutableLiveData<String>
    {
        mutableLiveData=repositry2.getMutableDataString()
        return mutableLiveData
    }
}