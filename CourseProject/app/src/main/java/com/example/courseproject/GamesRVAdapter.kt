package com.example.courseproject

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.courseproject.databinding.ItemGameBinding

class GamesRVAdapter(val presenter: IGamesListPresenter, val imageLoader:
IImageLoader<ImageView>) : RecyclerView.Adapter<GamesRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemGameBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)).apply {
            itemView.setOnClickListener {
                presenter.itemClickListener?.invoke(this) }
        }
    override fun getItemCount() = presenter.getCount()
    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })
    inner class ViewHolder(val vb: ItemGameBinding) :
        RecyclerView.ViewHolder(vb.root), GameItemView {
        override var pos = -1
        override fun setName(name: String) = with(vb) {
            tvGameInfo.text ="${tvGameInfo.text}$name\n"
        }

        override fun setReleasedDate(date: String)
         = with(vb) {
            tvGameInfo.text = "${tvGameInfo.text}$date\n"
        }
        override fun setRating(rating: Double)
        = with(vb) {
            tvGameInfo.text = "${tvGameInfo.text}$rating\n"
        }
        override fun loadImage(url: String) = with(vb) {
            imageLoader.loadInto(url, ivGameImage)
        }
    }
}