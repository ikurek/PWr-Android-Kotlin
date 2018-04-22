package com.igor.wyklad2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_user.*

class userActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        getUserEmail()
    }

    private fun getUserEmail() {

        // Wyciągnięcie wartości email z extra
        // Przekazanego poprzez intencję
        // @email_param jest kluczem pod którym znajduje się wartość
        var email = intent.getStringExtra("email_param")

        // Przypisanie otrzymanej wartości do pola tekstowego
        email_param_text.text = email
    }
}
