package com.example.notemvppattern.presenter

import com.example.notemvppattern.model.PosterResp

interface MainPresenterImpl {
    fun allPoster()
    fun postDelete(posterResp: PosterResp)
}