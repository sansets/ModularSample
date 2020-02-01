package com.sandisetiawan444.moviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sandisetiawan444.movie.ui.MovieFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, MovieFragment())
                .commit()
        }
    }
}
