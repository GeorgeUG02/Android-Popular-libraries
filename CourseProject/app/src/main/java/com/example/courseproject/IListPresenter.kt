package com.example.courseproject

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}
interface IGamesListPresenter : IListPresenter<GameItemView>
