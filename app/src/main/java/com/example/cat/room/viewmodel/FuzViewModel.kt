package com.example.cat.room.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.cat.room.db.BaeDatabase
import com.example.cat.room.entity.NutEntity
import com.example.cat.room.repository.NutRepository
import com.example.cat.room.repository.ZapRepository
class FuzViewModel (application: Application) : AndroidViewModel(application) {
    private val nutrository: NutRepository
    private val zaprository: ZapRepository
    init {
        val nutDao = BaeDatabase.getDatabase(application).nutDao()
        nutrository = NutRepository(nutDao)
        val zapDao = BaeDatabase.getDatabase(application).zapDao()
        zaprository = ZapRepository(zapDao)
    }

    fun addNut(data: List<NutEntity>) {
        nutrository.addNut(data)
    }
    fun getAllNut(): List<NutEntity>? {
        return nutrository.getAllNut()
    }
}