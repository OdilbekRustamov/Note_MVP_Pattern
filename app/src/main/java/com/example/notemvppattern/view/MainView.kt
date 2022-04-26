package com.example.notemvppattern.view

import com.example.notemvppattern.model.PosterResp

interface MainView {

    fun onPostListSuccrss(posts: ArrayList<PosterResp>?)
    fun opPostListFailure(error: String)

    fun onPostDeleteSuccess(post: PosterResp?)
    fun onPostDeleteFailure(error: String)
}