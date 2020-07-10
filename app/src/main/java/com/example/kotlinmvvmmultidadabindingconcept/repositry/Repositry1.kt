package com.example.kotlinmvvmmultidadabindingconcept.repositry

import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class Repositry1
{
    @Inject
    constructor()
    var mutableLiveData=MutableLiveData<String>()

    fun getMutableData()
    {
       mutableLiveData.value ="This is First repositry1";
    }
    fun  getMutableDataString():MutableLiveData<String>
    {
        return mutableLiveData
    }
}