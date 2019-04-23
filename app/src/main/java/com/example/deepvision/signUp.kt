package com.example.deepvision

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent

class signUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }

    fun sign_up(view: View){
        // TODO: Check all fields are submitted

        // TODO: Check username, email  and password requirements.

        // TODO: Send info to server and wait for an answer --> Error if registered else return to login



        // Return to log in if all correct
        val intent = Intent(this, logIn::class.java)
        startActivity(intent)



    }



}
