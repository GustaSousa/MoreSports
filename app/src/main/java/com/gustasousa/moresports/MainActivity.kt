package com.gustasousa.moresports

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gustasousa.moresports.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bt_ver_noticia = binding.btVerNoticias
        val bt_nova_noticia = binding.btNovaNoticia

        bt_nova_noticia.setOnClickListener {
            val inten = Intent(this, NovaNoticiaActivity::class.java)
            startActivity(inten)
        }
        supportActionBar!!.hide()


    }
}