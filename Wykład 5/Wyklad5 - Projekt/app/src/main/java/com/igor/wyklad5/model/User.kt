package com.igor.wyklad5.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Klasa przechowuje model danych, wykorzystywany przez bazę danych
 * Jako pojedyncza encja (wiersz tabeli)
 */

// Adnotacja określająca, że dana klasa jest wierszem tabeli
// parametr tableName określa nazwę tabeli, w której przechowywane
// Będą wszystkie obiekty tego typu
@Entity(tableName = "Users")
// Konstrukcja "data class" służy do tworzenia klas
// Których zadaniem jest reprezentowanie modelu danych
data class User(
        // Adnotacja określa klucz podstawowy w tabeli SQL
        // Parametr autoGenerate powoduje, że w momencie umieszczenia
        // W bazie, obiekt uzyskuje w niej kolejne ID
        @PrimaryKey(autoGenerate = true)
        val id: Int,

        // Adnotacje określają, że zmienna ma zostać
        // Umieszczona w tabeli w kolumnie o podanej nazwie
        @ColumnInfo(name = "name")
        var name: String,
        @ColumnInfo(name = "surname")
        var surname: String,
        @ColumnInfo(name = "age")
        var age: Int
)