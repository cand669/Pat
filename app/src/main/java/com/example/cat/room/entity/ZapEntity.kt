package com.example.cat.room.entity
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
@Entity(tableName = "zap_table")
@Parcelize
data class ZapEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
) : Parcelable {

}