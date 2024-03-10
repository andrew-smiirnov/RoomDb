package com.example.roomdb.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao // эти аннотации для библиотеки room, чтобы она понимала что это за класс и как с ним взаимодействовать
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // onConflict дает выбрать, что делать при
    suspend fun insertItem(nameEntity: NameEntity)   // попытке записи в БД данных с уже имеющимся
                                                     // в БД идентификатором
    @Delete
    suspend fun deleteItem(nameEntity: NameEntity)

    @Update
    suspend fun updateItem(nameEntity: NameEntity)

    @Query("SELECT * FROM name_table") // аннотация уже не из библ. room, а прямое обращение к БД SQL-lite
    fun getAllItems(): Flow<List<NameEntity>>
    // suspend fun getAllItems(): List<NameEntity> не автоматизированный способ получения данных из
    // БД. Для получения данных его придется запускать каждый раз. Flow уже запускается в coroutunes
    // и через CollectAsState позволяет получать данные сразу при любом изменении в БД.
    // Если необходимо получение отфильтрованных данных, то запрос в @Query меняется на нужный и
    // данные получаем через suspend fun getAllItems(): List<NameEntity>
}