package com.example.notemvppattern.networking

import com.example.notemvppattern.model.Poster
import com.example.notemvppattern.model.PosterResp
import retrofit2.Call
import retrofit2.http.*

interface PostService {
    @Headers(
        "Content-type:application/json"
    )
    @GET("note")
    fun listPost(): Call<ArrayList<PosterResp>>

    @GET("note/{id}")
    fun singlePost(@Path("id") id: Int): Call<PosterResp>

    @POST("note")
    fun createPost(@Body post: Poster): Call<PosterResp>

    @PUT("note/{id}")
    fun updatePost(@Path("id") id: Int, @Body post: Poster): Call<PosterResp>

    @DELETE("note/{id}")
    fun deletePost(@Path("id")id: Int): Call<PosterResp>
}