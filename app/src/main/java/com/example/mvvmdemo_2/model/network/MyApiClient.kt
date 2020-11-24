package com.example.mvvmdemo_2.model.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApiClient {
    @FormUrlEncoded
    @POST("login")
    fun ApiClientuserLogin(@Field("email")  email : String,  @Field("password")  password : String) : Call<ResponseBody>

companion object {
     fun MyGetResponse() : MyApiClient{
         val  myRetrofit = Retrofit.Builder()
             .baseUrl("https://grocery-second-app.herokuapp.com/api/auth/")
             .addConverterFactory(GsonConverterFactory.create())
             .build()
             .create(MyApiClient::class.java)

         return  myRetrofit
    }
}


}

