package com.example.mvvmdemo_2.view

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmdemo_2.model.repo.UserRepo

class AuthViewModel : ViewModel() {

    var email : String? = null
    var pwd : String? = null

     var authListener : AuthListener? = null

    fun onLoginClickButton(view : View){

        authListener?.onStarted()
        if(email.isNullOrEmpty() || (pwd.isNullOrEmpty())){

            authListener?.onFailure("invalid email or pwd")

        }

        else{
                val myresponse = UserRepo().userLogin(email!!,pwd!!)
                authListener?.onSuccess(myresponse)
        }


    }
}