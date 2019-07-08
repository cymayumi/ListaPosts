package com.mayumi.starwars.servico


import com.mayumi.starwars.model.Posts
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface WebApi {

    @GET("posts")
    fun getList():  Call<List<Posts>>

}