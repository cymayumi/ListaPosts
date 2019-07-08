package com.mayumi.starwars.ui.act001

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mayumi.starwars.ui.act002.ListaActivity
import com.mayumi.starwars.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initVar()
        initActions()
    }

    private fun initVar() {
        context = this@MainActivity
    }

    private fun initActions() {
        btn_filmes.setOnClickListener {
            val mIntent = Intent(context, ListaActivity::class.java)

            startActivity(mIntent)
            finish()
        }
    }
}
