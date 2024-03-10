package com.example.roomdb.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "name_table") // позволяет задать произвольное имя создаваемой таблице
data class NameEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    // @ColumnInfo(name = "Name") // позволяет задать произвольное имя столбцу в создаваемой таблице
    val name: String
)
