package com.example.lesson2homework

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}
interface IUserListPresenter : IListPresenter<UserItemView>
interface IListPresenter2<V:IItemView>{
    fun bindView(view: V)
    fun getCount(): Int
}
interface IRepoListPresenter:IListPresenter2<RepoItemView>