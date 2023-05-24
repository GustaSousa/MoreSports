package com.gustasousa.moresports

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gustasousa.moresports.databinding.NovaNoticiaBinding

class NovaNoticiaActivity : AppCompatActivity() {

    private lateinit var binding: NovaNoticiaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NovaNoticiaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

    }
}