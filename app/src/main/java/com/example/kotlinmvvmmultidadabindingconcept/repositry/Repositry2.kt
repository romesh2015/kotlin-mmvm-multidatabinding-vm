package com.example.kotlinmvvmmultidadabindingconcept.repositry

import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class Repositry2 {
    @Inject
    constructor()
    var mutableLiveData= MutableLiveData<String>()

    fun getMutableData()
    {
        mutableLiveData.value ="This is First repositry2";
    }
    fun  getMutableDataString(): MutableLiveData<String>
    {
        return mutableLiveData
    }
}