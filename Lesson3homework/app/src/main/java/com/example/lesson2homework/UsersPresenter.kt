package com.example.lesson2homework

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter

class UsersPresenter(private val usersRepo: GithubUsersRepo,private val router: Router) :
    MvpPresenter<UsersView>() {
    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null
        override fun getCount() = users.size
        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = { itemView ->
//TODO: переход на экран пользователя c помощью router.navigateTo
            router.navigateTo(AndroidScreens.user(usersListPresenter.users[itemView.pos].login))

        }
    }
    fun loadData() {
        usersRepo.createJust().subscribe({
            s->usersListPresenter.users.add(s)
        },{println("onError: ${it.message}")})
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}