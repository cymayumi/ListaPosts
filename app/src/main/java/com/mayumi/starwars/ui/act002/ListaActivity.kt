package com.mayumi.starwars.ui.act002

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mayumi.starwars.R
import com.mayumi.starwars.model.Posts
import com.mayumi.starwars.servico.ServiceBuilder
import com.mayumi.starwars.servico.WebApi
import com.mayumi.todo_teste.lista.MeuAdapter
import kotlinx.android.synthetic.main.activity_lista.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var meuAdapter: MeuAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        initVar()
        initActions()
    }

    private fun initVar() {
        context = this@ListaActivity

    }

    private fun initActions() {
        carregarLista()
    }

    private fun carregarLista() {
        val destinationService = ServiceBuilder.buildService(WebApi::class.java)
        val requestCall = destinationService.getList()

        requestCall.enqueue(object : Callback<List<Posts>> {

            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                if (response.isSuccessful) {
                    var listaPosts = response.body()!!

                    meuAdapter = MeuAdapter(
                        context,
                        R.layout.celula,
                        listaPosts
                    )

                    lista_id.adapter = meuAdapter

                }
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Toast.makeText(context, "Ocorreu um erro!", Toast.LENGTH_LONG).show()
            }
        })
    }
}