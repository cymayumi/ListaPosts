package com.mayumi.todo_teste.lista


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mayumi.starwars.R
import com.mayumi.starwars.model.Posts
import kotlinx.android.synthetic.main.celula.view.*


class MeuAdapter(private var data: List<Posts>) : RecyclerView.Adapter<MeuAdapter.ListaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.celula, parent, false)
        return ListaViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return  data.count()
    }

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class ListaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val titulo = itemView.tv_titulo
        private val comentario = itemView.tv_comentario

        fun bind(item: Posts) {
            titulo.text = item.title
            comentario.text = item.body
        }
    }

}