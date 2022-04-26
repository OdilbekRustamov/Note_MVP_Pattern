package com.example.notemvppattern.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notemvppattern.MainActivity
import com.example.notemvppattern.databinding.ItemPostViewBinding
import com.example.notemvppattern.model.PosterResp

class PostAdapter(var activit: MainActivity, var posts: ArrayList<PosterResp>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var binding: ItemPostViewBinding

    inner class ViewHolder(val binding: ItemPostViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemPostViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        with(holder){
            with(posts[position]){
                binding.tvTheme.text = this.theme
                binding.tvTitle.text = this.title
                binding.tvTime.text = this.time

                binding.tvDelete.setOnClickListener {
                    activit.mainPresenter.postDelete(this)
                }
            }
        }
    }

    override fun getItemCount(): Int{
        return posts.size
    }
}