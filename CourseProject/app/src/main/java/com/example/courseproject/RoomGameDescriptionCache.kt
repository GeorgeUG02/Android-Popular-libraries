package com.example.courseproject

class RoomGameDescriptionCache(private val database: Database):IGameDescriptionCache {
    override fun cache(id: Int, gameDescription:GameDescription) {
        val roomGameDescription = RoomGameDescription(id,gameDescription.name?:"",
                gameDescription.description ?: "", gameDescription.metacritic?:0.0)
        database.gameDescriptionDao.insert(roomGameDescription)
    }

}