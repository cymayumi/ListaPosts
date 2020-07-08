package com.mayumi.todo_teste.lista

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mayumi.starwars.R
import com.mayumi.starwars.model.Posts


class MeuAdapter(
    private val context: Context,
    private var data: List<Posts>
) : RecyclerView.Adapter<ListaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.celula, parent, false)
        return ListaViewHolder(view)
    }

    override fun getItemCount(): Int {
        //how many itens we have
        return data.size
    }

    override fun getItemId(position: Int): Long {
        return data[position].id.toLong()
    }

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        //how to draw an item at the specified position
        val item = data[position]
        holder.bind(item)

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Você clicou no item "+ position, Toast.LENGTH_LONG).show()
        }
    }
}

class ListaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titulo = itemView.findViewById<TextView>(R.id.tv_titulo)
    private val comentario = itemView.findViewById<TextView>(R.id.tv_comentario)

    fun bind(item: Posts) {
        titulo.text = item.title
        comentario.text = item.body
    }
}