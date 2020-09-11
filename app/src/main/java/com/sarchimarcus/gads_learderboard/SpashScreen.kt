package com.sarchimarcus.gads_learderboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SpashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spash_screen)

        Handler().postDelayed(Runnable {
            startActivity(Intent(this,MainActivity::class.java))
        },500)
    }
}
