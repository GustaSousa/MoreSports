package com.gustasousa.moresports

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.gustasousa.moresports.databinding.NovaNoticiaBinding

class NovaNoticiaActivity : AppCompatActivity() {

    private lateinit var binding: NovaNoticiaBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NovaNoticiaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.btPublicar.setOnClickListener {

            val titulo = binding.editTitulo.text.toString()
            val noticia = binding.editNoticia.text.toString()
            val data = binding.editdata.text.toString()
            val autor = binding.editautor.text.toString()

            if(titulo.isEmpty()||noticia.isEmpty()||data.isEmpty()||autor.isEmpty()) {
                Toast.makeText(this,"Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
            else{
                salvarNoticia(titulo,noticia,data,autor)
            }
        }
    }
    private fun salvarNoticia(titulo: String, noticia: String, data: String, autor: String){

        val mapNoticia = hashMapOf(
            "titulo" to titulo,
            "noticia" to noticia,
            "data" to data,
            "autor" to autor
        )
        db.collection("noticias").document("noticia").set(mapNoticia).addOnCompleteListener{ tarefa ->
                if (tarefa.isSuccessful){
                    Toast.makeText(this,"Noticia salva com sucesso",Toast.LENGTH_SHORT).show()
                    limparCampos()
                }
            }.addOnFailureListener{

            }
    }

    private fun limparCampos(){
        binding.editTitulo.setText("")
        binding.editNoticia.setText("")
        binding.editdata.setText("")
        binding.editautor.setText("")
    }
}