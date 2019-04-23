package com.example.deepvision

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.content.Intent

//import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed(
            {// This method will be executed once the timer is over
                val intent = Intent(this, logIn::class.java)
                startActivity(intent)
            },
            1000 // value in milliseconds
        )
    }



//    /** Method called when the user taps the log-in button*/
//    fun logIn(view: View){
//
//        // Collect log-in data from intercace
//        val editText = findViewById<EditText>(R.id.editText)
//        val user = editText.text.toString()
//
//        val editText2 = findViewById<EditText>(R.id.editText2)
//        val password = editText2.text.toString()
//
//        // TODO: if statement checking user in logging data base
//
//        // Call selectProjectActivity (if logging successful)
//        val intent = Intent(this, logIn::class.java)
//    }
}
