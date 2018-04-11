package com.igor.wyklad1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hello.setOnClickListener {
           hello.text = "test"
            Toast.makeText(
                    applicationContext,
                    "Hello!",
                    Toast.LENGTH_LONG).show()
        }

        button.setOnClickListener {
            hello.text = "coś innego"
        }
    }
}
