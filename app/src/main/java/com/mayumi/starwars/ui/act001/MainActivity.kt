package com.mayumi.starwars.ui.act001

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mayumi.starwars.ui.act002.ListaActivity
import com.mayumi.starwars.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityContract.I_View {

    private lateinit var context: Context
    private lateinit var mPresenter : MainActivityContract.I_Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initVar()
        initActions()
    }

    private fun initVar() {
        context = this@MainActivity
        mPresenter = MainActivityPresenter(this)

    }

    private fun initActions() {
        btn_filmes.setOnClickListener {
            executaNavegacao()
        }
    }

    override fun executaNavegacao() {
        val mIntent = Intent(context, ListaActivity::class.java)

        startActivity(mIntent)
        finish()
    }


}
