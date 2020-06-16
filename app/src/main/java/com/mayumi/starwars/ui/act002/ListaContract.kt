package com.mayumi.starwars.ui.act002

import com.mayumi.starwars.model.Posts

interface ListaContract {
    interface I_View {
        fun showLista(lista: List<Posts>)
        fun showErrorMsg()
    }

    interface I_Presenter {
        fun carregarLista()
    }
}