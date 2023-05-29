package com.gustasousa.moresports

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.gustasousa.moresports.databinding.NoticiasBinding
import com.gustasousa.moresports.databinding.NovaNoticiaBinding

class NoticiasActivity : AppCompatActivity() {

    private lateinit var binding: NoticiasBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NoticiasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        recuperarNoticia()
    }

    private fun recuperarNoticia (){
        db.collection("noticias").document("noticia").get().addOnCompleteListener{ documento->
            if (documento.isSuccessful){
                val titulo = documento.result.get("titulo").toString()
                val noticia = documento.result.get("noticia").toString()
                val autor = documento.result.get("autor").toString()
                val data = documento.result.get("data").toString()

                binding.txtTitulo.text = titulo
                binding.txtNoticia.text = noticia
                binding.txtAutor.text = autor
                binding.txtData.text = data
            }
        }
    }
}