package com.example.cat.room.repository
import com.example.cat.room.dao.NutDao
import com.example.cat.room.entity.NutEntity

class NutRepository ( val dao: NutDao) {

    fun addNut(data: List<NutEntity>) {
        dao.addNut(data)
    }
    fun getAllNut(): List<NutEntity>? {
        return dao.getAllNut()
    }
}