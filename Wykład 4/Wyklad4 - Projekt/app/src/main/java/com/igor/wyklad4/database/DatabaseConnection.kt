package com.igor.wyklad4.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.igor.wyklad4.model.User

/**
 * Klasa jest podstawą połączenia z bazą danych
 * Dziedziczy po klasie RoomDatabase
 * Przechowuje wszelkie odniesienia do DAO
 */

// Adnotacja określająca encje tabel, wersję bazy danych
// Oraz exportowanie schematu
@Database(entities = arrayOf(User::class),
        version = 1,
        exportSchema = false)
abstract class DatabaseConnection() : RoomDatabase() {

    // Przykładowy DAO (Obiekt dostępu do danych)
    abstract fun userDAO(): UserDAO

}