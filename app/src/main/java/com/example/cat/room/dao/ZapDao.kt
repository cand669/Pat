package com.example.cat.room.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cat.room.entity.ZapEntity

@Dao
interface ZapDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addZap(data: ZapEntity)
}