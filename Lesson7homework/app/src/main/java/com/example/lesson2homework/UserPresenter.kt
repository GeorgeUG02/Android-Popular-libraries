package com.example.lesson2homework

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import javax.inject.Inject

class UserPresenter(val login:String) :
    MvpPresenter<ListView>() {
    @Inject lateinit var repositoriesRepo: IGithubRepositoriesRepo
    @Inject lateinit var router: Router
    @Inject lateinit var uiScheduler: Scheduler
    class UserListPresenter : IRepoListPresenter {
        val repos = mutableListOf<GithubRepo>()
        override fun getCount() = repos.size
        override fun bindView(view: RepoItemView) {
            val repo = repos[view.pos]
            repo.full_name?.let{view.setName(it)}
            repo.private?.let{view.setPrivate(it)}
            repo.forks?.let{view.setForks(it)}
        }
    }

    val repoListPresenter = UserListPresenter()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }
    fun loadData() {
        repositoriesRepo.getRepositories(login)
            .observeOn(uiScheduler)
            .subscribe({ repos ->
                repoListPresenter.repos.clear()
                repoListPresenter.repos.addAll(repos)
                viewState.updateList()
            }, {
                println("Error: ${it.message}")
            })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}