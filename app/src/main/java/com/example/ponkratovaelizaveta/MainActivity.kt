package com.example.ponkratovaelizaveta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ponkratovaelizaveta.db.JokesLocalDataSource
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var jokesDBS: JokesLocalDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}