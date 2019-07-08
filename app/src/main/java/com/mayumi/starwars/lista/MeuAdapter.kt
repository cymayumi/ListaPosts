package com.mayumi.todo_teste.lista

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import com.mayumi.starwars.R
import com.mayumi.starwars.model.Posts


class MeuAdapter(
    private val context: Context,
    private var resource: Int,
    private var listaPosts: List<Posts>
) : BaseAdapter() {

    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var mView = convertView

        if (mView == null) {
            mView = mInflater.inflate(resource, parent, false)
        }

        var ll_title = mView?.findViewById<TextView>(R.id.tv_titulo)
        var ll_comentario = mView?.findViewById<TextView>(R.id.tv_comentario)

        var item = listaPosts [position]

        ll_title?.setText(item.title)
        ll_comentario?.setText(item.body)

        return mView!!
    }

    override fun getItem(position: Int): Any {
        return listaPosts[position]
    }

    override fun getItemId(position: Int): Long {
        return listaPosts[position].id.toLong() ?: 0L
    }

    override fun getCount(): Int {
        return listaPosts.size
    }
}