package com.igor.wyklad4

import android.arch.persistence.room.Room
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.igor.wyklad4.database.DatabaseConnection
import com.igor.wyklad4.model.User
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        getUserEmail()
        bindRecyclerView()
        connectToDatabase()
    }

    private fun getUserEmail() {

        // Wyciągnięcie wartości email z extra
        // Przekazanego poprzez intencję
        // @email_param jest kluczem pod którym znajduje się wartość
        var email = intent.getStringExtra("email_param")


    }

    /**
     * Metoda ustawia odpowiednie parametry
     * Oraz deklaruje adapter do listowego
     * Widoku RecyclerView
     */
    private fun bindRecyclerView() {

        // Stworzenie testowej listy, używanej
        // Jako zbiór danych dla wodoku listowego
        val list: List<String> =
                listOf("Test", "Test2", "Test3")

        // Do RecyclerView przypisany zostaje Layout Manager
        // W tym wypadku korzystamy z LinearLayoutManager
        // Elementy będą więc traktowane jako kolejne linie
        recycler_view.layoutManager = LinearLayoutManager(this)

        /**
         * Do tego samego RecyclerView przypisujemy adapter
         * Znajdujący się w pliku MyRecyclerViewAdapter
         * jako parametry jego konstruktora podajemy kolejno
         * Context, listę danych, oraz Unit wywoływany w momencie
         * Kliknięcia któregoś z elementów listy
         */
        recycler_view.adapter = MyRecyclerViewAdapter(this, list, { position ->

            // Wyświetlenie okienka Toast w momencie kliknięcia
            Toast.makeText(this, "clicked $position", Toast.LENGTH_LONG).show()

        })
    }

    // Funkcja obrazuje sposób, w jaki można ustanowić połączenie
    // Z bazą danych SQL
    private fun connectToDatabase() {
        // Stworzenie obiektu przechowującego połączenie z bazą
        // Zazwyczaj obiekt ten tworzy się jako singleton
        // Czyli przechowuje tylko jedną jego instancję
        // Nie chciałem jednak przesadnie komplikować kodu
        var database = Room.databaseBuilder(
                applicationContext,
                DatabaseConnection::class.java,
                "MyUserDatabse.db")
                .build()

        // Stworzenie przykładowego obiekty typu User
        var user = User(13,
                "Test",
                "Testowy",
                12)


        // Operacje na bazie danych nie mogą być wywoływane w głównym wątku
        // Tworzymy więc asynchroniczne zadanie (osobny wątek)
        // I w nim wykonujemy kod
        AsyncTask.execute {
            // Wywołanie metody z DAO
            // W tym wypadku, jest to metoda umieszczająca element w bazie danych
            database.userDAO().insertUser(user)
        }
    }
}
