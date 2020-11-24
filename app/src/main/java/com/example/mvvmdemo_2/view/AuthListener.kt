package com.example.mvvmdemo_2.view

import androidx.lifecycle.LiveData

interface AuthListener {

    fun onStarted()
    fun onSuccess(myresponse: LiveData<String>)
    fun onFailure(message : String)
}