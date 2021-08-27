package com.example.lesson2homework

class RoomUserCache(private val database: Database):IUserCache {
    override fun cache(users:List<GithubUser>){
        val roomUsers = users.map { user ->
            RoomGithubUser(user.id ?: "", user.login ?: "", user.avatarUrl ?: "") }
        database.userDao.insert(roomUsers)
    }
}