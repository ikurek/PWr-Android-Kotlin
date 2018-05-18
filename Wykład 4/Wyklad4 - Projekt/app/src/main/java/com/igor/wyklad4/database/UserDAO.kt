package com.igor.wyklad4.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.ABORT
import android.arch.persistence.room.Query
import com.igor.wyklad4.model.User

/**
 * Interfejs jest przykładem działania obiektu typu DAO
 * Zapewnia dostep do metod wykonywanych na bazie SQL
 * Poprzez system adnotacji przypisanych do funkcji
 */

// Adnotacja identyfikująca interfejs jako typ DAO
@Dao
interface UserDAO {

    // Adnotacja query, wykonująca dane zapytanie SQL na bazie
    // Określona pod nią funkcja w momencie wykonania zwróci
    // Obiekty otrzymane z bazy danych
    @Query("SELECT * FROM Users")
    fun getAllUsers(): List<User>

    // Adnotacja insert poowduje umieszczenie podanego obiektu w bazie danych
    // Parametr onConflict określa zachowanie w momencie, kiedy dany obiekt już istnieje w bazie
    @Insert(onConflict = ABORT)
    fun insertUser(userToInsert: User)

    // Adnotacja delete powoduje usunięcie danego obiektu z bazy danych
    @Delete
    fun deleteUser(userToDelete: User)
}