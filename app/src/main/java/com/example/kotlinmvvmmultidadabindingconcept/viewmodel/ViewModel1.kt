package com.example.kotlinmvvmmultidadabindingconcept.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmvvmmultidadabindingconcept.repositry.Repositry1
import javax.inject.Inject

class ViewModel1 :ViewModel{
    @Inject
    constructor()
    var repositry1=Repositry1()
    var mutableLiveData=MutableLiveData<String>()
    fun  callData()
    {
        repositry1.getMutableData()
    }
    fun  getMutableDataString():MutableLiveData<String>
    {
       mutableLiveData=repositry1.getMutableDataString()
        return mutableLiveData
    }
}