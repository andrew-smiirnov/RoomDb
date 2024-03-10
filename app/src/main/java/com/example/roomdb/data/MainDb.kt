package com.example.roomdb.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        NameEntity::class // в массив вносятся все базы используемые в приложении
    ],
    version = 1
)
abstract class MainDb : RoomDatabase() {
    abstract val dao: Dao
    companion object{
        fun createDatabase(context: Context): MainDb{
            return Room.databaseBuilder(
                context,    // контекст откуда яберется информация для создания БД
                MainDb::class.java, // класс который создает БД
                "test.db" // путь, например, из InternalStorage (если без пути, то путь по умолчанию)
            ).build()
        }
    }
}