package com.mayumi.starwars.ui.act002

import com.mayumi.starwars.model.Posts
import com.mayumi.starwars.servico.ServiceBuilder
import com.mayumi.starwars.servico.WebApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaPresenter(private var mView: ListaContract.I_View?) : ListaContract.I_Presenter {

    override fun carregarLista() {
        val destinationService = ServiceBuilder.buildService(WebApi::class.java)
        val requestCall = destinationService.getList()

        requestCall.enqueue(object : Callback<List<Posts>> {

            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                if (response.isSuccessful) {
                    var listaPosts = response.body()!!
                    mView?.showLista(listaPosts)
                }
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                mView?.showErrorMsg()
            }
        })
    }
}