package com.example.notemvppattern

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import com.example.notemvppattern.adapter.PostAdapter
import com.example.notemvppattern.databinding.ActivityMainBinding
import com.example.notemvppattern.model.PosterResp
import com.example.notemvppattern.networking.RetrofitHttp
import com.example.notemvppattern.presenter.MainPresenter
import com.example.notemvppattern.view.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MainView {
    lateinit var binding: ActivityMainBinding
    lateinit var mainPresenter: MainPresenter

    override fun onResume() {
        super.onResume()
        mainPresenter.allPoster()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        mainPresenter = MainPresenter(this)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 1)

        binding.ivAdd.setOnClickListener {
            val intent = Intent(this, AddPostActivity::class.java)
            startActivity(intent)
        }

        mainPresenter.allPoster()
    }

    private fun refreshAdapter(posts: ArrayList<PosterResp>) {
        val adapter = PostAdapter(this, posts)
        binding.recyclerView.adapter = adapter
    }

    override fun onPostListSuccrss(posts: ArrayList<PosterResp>?) {
        refreshAdapter(posts!!)
    }

    override fun opPostListFailure(error: String) {
        TODO("Not yet implemented")
    }

    override fun onPostDeleteSuccess(post: PosterResp?) {
        mainPresenter.allPoster()
    }

    override fun onPostDeleteFailure(error: String) {
        TODO("Not yet implemented")
    }


}