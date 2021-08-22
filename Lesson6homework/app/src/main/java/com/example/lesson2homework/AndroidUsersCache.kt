package com.example.lesson2homework

class AndroidUsersCache:IUserCache {
    override fun cache(users:List<GithubUser>){
        val roomUsers = users.map { user ->
            RoomGithubUser(user.id ?: "", user.login ?: "", user.avatarUrl ?: "") }
        Database.getInstance().userDao.insert(roomUsers)
    }
}