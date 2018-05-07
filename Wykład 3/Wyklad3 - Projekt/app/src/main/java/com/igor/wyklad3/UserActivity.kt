package com.igor.wyklad3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        getUserEmail()
        bindRecyclerView()
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
}
