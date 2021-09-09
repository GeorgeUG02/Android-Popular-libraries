package com.example.courseproject

class RoomGamesCache(private val database: Database):IGamesCache {
    override fun cache(games:Games){
        val roomGames = games.results?.map { game ->
            RoomGame(game.id ?: 0, game.name ?: "", game.released ?: "",game.background_image?:"",game.rating?:0.0) }
        database.gameDao.insert(roomGames!!)
    }
}