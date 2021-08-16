package com.example.lesson2homework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson2homework.databinding.ItemRepoBinding

class RepoRVAdapter(val repos:List<GithubRepo>): RecyclerView.Adapter<RepoRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemRepoBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.vb.textView2.text="full name = ${repos[position].full_name}" +
                "\n"+"private = ${repos[position].private}" +
                "\n"+"forks : ${repos[position].forks}"
    }

    override fun getItemCount(): Int {
        return repos.size
    }
    inner class ViewHolder(val vb:ItemRepoBinding):RecyclerView.ViewHolder(vb.root){

    }
}