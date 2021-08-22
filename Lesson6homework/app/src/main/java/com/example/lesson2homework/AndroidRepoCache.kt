package com.example.lesson2homework

class AndroidRepoCache:IRepositoriesCache {
    override fun cache(id: String, repositories: List<GithubRepo>) {
        val roomRepos = repositories.map {
            RoomGithubRepository(it.id.toString()?:"",
                it.full_name ?: "", it.forks?:0,it.private ?: false,id?:"")
        }
        Database.getInstance().repositoryDao.insert(roomRepos)
    }

}