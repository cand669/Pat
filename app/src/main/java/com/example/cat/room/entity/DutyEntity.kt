package com.example.cat.room.entity
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.cat.room.converter.LocalDateConverter
import java.time.LocalDate
import kotlinx.parcelize.Parcelize
@Entity(tableName = "duty_table")
@TypeConverters(LocalDateConverter::class)
@Parcelize
data class DutyEntity(
    val localDate: LocalDate,
    val xn: Int = 0,
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
) : Parcelable {

}