package com.deepsaikia.nitsgms

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        val intent = Intent(
            this@AuthActivity,
            MainActivity::class.java
        )
        startActivity(intent)
    }
}