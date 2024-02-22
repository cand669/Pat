package com.example.cat.room.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cat.room.entity.NutEntity

@Dao
interface NutDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addNut(data: List<NutEntity>)

    @Query("SELECT * FROM nut_table WHERE localDate <= date('now') ORDER BY id DESC LIMIT 30")
    fun getAllNut(): List<NutEntity>?
//
//
//    @Query("SELECT * FROM duty_table WHERE strftime('%Y', localDate) = :currentYear AND strftime('%m', localDate) = :currentMonth ORDER BY id DESC LIMIT 30")
//    fun csdw(currentYear: Int, currentMonth: Int): List<DutyEntity>?
//
//
//    @Query("UPDATE duty_table SET  x0 = x0 + 1 WHERE localDate == date('now')")
//    fun oos()
//
//    @Query("SELECT id,localDate,x0+x1 as xn FROM duty_table WHERE xn >= 100")
//    fun x0ad(): List<DutyEntity0>?
//
//    @Query("UPDATE duty_table SET  x1 = 5 WHERE localDate == date('now') and x1  == 0")
//    fun x1ad()
//
//    @Query("UPDATE duty_table SET  x2 = x2 + 1 WHERE localDate == date('now')")
//    fun x2ad()
//
//    @Query("UPDATE duty_table SET  x3 = x3 + 1 WHERE localDate == date('now')")
//    fun x3ad()
//
//
//    @Query("UPDATE duty_table SET  x0 = :js WHERE localDate == :localDate")
//    fun zaps(localDate: String, js: Int)
}