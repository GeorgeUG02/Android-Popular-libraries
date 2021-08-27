package com.example.lesson2homework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson2homework.databinding.ItemRepoBinding

class RepoRVAdapter(val presenter: IRepoListPresenter): RecyclerView.Adapter<RepoRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    override fun getItemCount() = presenter.getCount()

    inner class ViewHolder(val vb: ItemRepoBinding) : RecyclerView.ViewHolder(vb.root),
        RepoItemView {
        override fun setName(name: String) {
            vb.textView2.text="${vb.textView2.text}$name\n"
        }

        override fun setPrivate(privateb: Boolean) {
            vb.textView2.text="${vb.textView2.text}$privateb\n"
        }

        override fun setForks(forks_count: Int) {
            vb.textView2.text="${vb.textView2.text}$forks_count\n"
        }

        override var pos = -1
    }
}