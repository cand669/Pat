package com.example.cat.room.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cat.room.dao.NutDao
import com.example.cat.room.entity.NutEntity
import com.example.cat.room.dao.ZapDao
import com.example.cat.room.entity.ZapEntity
@Database(
    entities = [NutEntity::class, ZapEntity::class],
    version = 1,
    exportSchema = false
)
abstract class BaeDatabase: RoomDatabase()  {
    abstract fun nutDao(): NutDao
    abstract fun zapDao(): ZapDao
    companion object {
        @Volatile
        var INSTANCE: BaeDatabase? = null

        fun getDatabase(context: Context): BaeDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.inMemoryDatabaseBuilder(
                    context,
                    BaeDatabase::class.java,
                ).allowMainThreadQueries().build()
                INSTANCE = instance

                return instance
            }

        }
    }
}
