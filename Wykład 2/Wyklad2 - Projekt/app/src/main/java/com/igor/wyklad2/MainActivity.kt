package com.igor.wyklad2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindButton()
    }

    // Funkcja sprawdzająca (bardzo prowizorycznie)
    // Czy adres email jest poprawny
    private fun checkData(email: String, password: String): Boolean {

        // Blok when zwróci z funkcji false
        // Jeżeli email jest pusty (isBlank())
        // Lub nie zawiera znaku @ (contains("@"))
        // W przeciwnym wypadku, zwróci true
        when {
            email.isBlank() ->  return false
            !email.contains("@") -> return false
            else -> return true
        }

    }

    // Funkcja symulująca logowanie użytkownika do jakiegoś systemu
    // Jeżeli dane są poprawne, uruchamia kolejną aktywność
    private fun loginUser() {

        // Wczytanie danych z pól tekstowych do zmiennych lokalnych
        var emailInCode: String = email_text.text.toString()
        var passwordInCode: String = password_text.text.toString()

        // Sprawdzamy przy pomocy utworzonej powyżej funkcji,
        // Czy dane są poprawne
        if(checkData(emailInCode, passwordInCode)) {
            // Kontunuacja, jeżeli są
            // Tworzymy intencję, która otworzy dla nas kolejną aktywność
            // podajemy aktualny kontekst oraz klasę reprezentującą activity
            var startActivityIntent: Intent = Intent(applicationContext, userActivity::class.java)

            // Dodajemy do naszej intencji extra, czyli dane
            // Które chcemy przekazać do kolejnej aktywności
            // W tym wypadku, pod kluczem email_param umieszczona
            // Jest wartość wczytanego wcześniej adresu email
            startActivityIntent.putExtra("email_param", emailInCode)

            // Startujemy aktywność korzystając z intencji
            startActivity(startActivityIntent)
        } else {
            // Jeżeli dane nie są poprawne
            // Wyświetlamy okno z informacją o błędzie
            Toast.makeText(applicationContext, "Niepoprawne dane", Toast.LENGTH_LONG).show()
        }

    }

    // Funkcja tworzy dowiązanie listenera
    // Do guzika w interfejsie
    private fun bindButton() {
        // Przypisanie guzika do lokalnej zmiennej
        var buttonInCode: Button = login_button
        // Przypisanie do guzika wywołania w momencie kliknięcia
        // Wywołującego funkcję loginUser()
        buttonInCode.setOnClickListener {
            loginUser()
        }
    }
}
