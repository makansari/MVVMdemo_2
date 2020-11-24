package com.example.mvvmdemo_2.model.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmdemo_2.model.network.MyApiClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepo {

    fun userLogin(email : String, password : String) :  LiveData<String>{
        val loginResponse = MutableLiveData<String>()

        MyApiClient.MyGetResponse().ApiClientuserLogin(email,password)
            .enqueue(object : Callback<ResponseBody>{
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if(response.isSuccessful){
                        loginResponse.value = response.body().toString()
                        Log.i("mytag" , "UserRepo success: " + response.body().toString())
                    }
                    else {
                        loginResponse.value = response.errorBody().toString()
                        Log.i("mytag" , "UserRepo failure: " + response.errorBody().toString())

                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    loginResponse.value = t.message
                }

            })

        return loginResponse
    }
}