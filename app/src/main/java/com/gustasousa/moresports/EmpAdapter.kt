package com.gustasousa.moresports

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmpAdapter(private val empList: ArrayList<Modelo>) :
    RecyclerView.Adapter<EmpAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.lista_noticias, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentEmp = empList[position]
        holder.historicoTitulo.text = currentEmp.empTitulo
        holder.historicoNoticia.text = currentEmp.empNoticia

    }

    override fun getItemCount(): Int {
        return empList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val historicoTitulo : TextView = itemView.findViewById(R.id.empTitulo)
        val historicoNoticia : TextView = itemView.findViewById(R.id.empNoticia)

    }
}