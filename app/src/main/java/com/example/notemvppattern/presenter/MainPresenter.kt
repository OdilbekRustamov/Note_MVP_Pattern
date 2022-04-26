package com.example.notemvppattern.presenter

import com.example.notemvppattern.model.PosterResp
import com.example.notemvppattern.networking.RetrofitHttp
import com.example.notemvppattern.view.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(var mainView: MainView): MainPresenterImpl {

    override fun allPoster() {
        RetrofitHttp.postService.listPost().enqueue(object : Callback<ArrayList<PosterResp>> {
            override fun onResponse(
                call: Call<ArrayList<PosterResp>>,
                response: Response<ArrayList<PosterResp>>,
            ) {
                mainView.onPostListSuccrss(response.body())
            }

            override fun onFailure(call: Call<ArrayList<PosterResp>>, t: Throwable) {
                mainView.opPostListFailure(t.toString())
            }

        })
    }

    override fun postDelete(posterResp: PosterResp) {
        RetrofitHttp.postService.deletePost(posterResp.id).enqueue(object : Callback<PosterResp>{
            override fun onResponse(call: Call<PosterResp>, response: Response<PosterResp>) {
                mainView.onPostDeleteSuccess(response.body())
            }

            override fun onFailure(call: Call<PosterResp>, t: Throwable) {
                mainView.onPostDeleteFailure(t.toString())
            }

        })
    }
}