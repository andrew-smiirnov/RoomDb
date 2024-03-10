package com.example.roomdb

import android.app.Application
import com.example.roomdb.data.MainDb

class App : Application() {
    /*
    Функция lazy позволяет создать БД при запуске приложения если её нет и обратиться к ней,
    если она уже была создана в предыдущих запусках.
    Контекст указывается this т.к. данный класс унаследован от анонимного класса Application и
    в дальнейшем приложение будет обращаться к нему для этого в манифесте задаём имя. В данном
    случае это будет ".App"
     */
    val database by lazy { MainDb.createDatabase(this) }
}