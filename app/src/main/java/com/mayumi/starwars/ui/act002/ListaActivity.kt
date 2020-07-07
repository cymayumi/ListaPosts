package com.mayumi.starwars.ui.act002

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mayumi.starwars.R
import com.mayumi.starwars.model.Posts
import com.mayumi.todo_teste.lista.MeuAdapter
import kotlinx.android.synthetic.main.activity_lista.*

class ListaActivity : AppCompatActivity(), ListaContract.I_View {

    private lateinit var context: Context
    private lateinit var meuAdapter: MeuAdapter
    private lateinit var mPresenter: ListaContract.I_Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        initVar()
        initActions()
    }

    private fun initVar() {
        context = this@ListaActivity
        mPresenter = ListaPresenter(this)
    }

    private fun initActions() {
        mPresenter.carregarLista()
    }

   /* override fun showLista(lista: List<Posts>) {
        meuAdapter = MeuAdapter(
            context,
            R.layout.celula,
            lista
        )

        lista_id.adapter = meuAdapter
    }*/

    override fun showLista(lista: List<Posts>) {
        lista_id.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MeuAdapter(context, lista)
        }
    }

    override fun showErrorMsg() {
        Toast.makeText(context, "Ocorreu um erro!", Toast.LENGTH_LONG).show()
    }
}