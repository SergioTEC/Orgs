package br.com.projeto.orgs.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.service.controls.actions.FloatAction
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.projeto.orgs.R
import br.com.projeto.orgs.dao.ProdutosDao
import br.com.projeto.orgs.model.Produto
import br.com.projeto.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val dao = ProdutosDao()
        Log.i("MainActivity", "onCreate: ${dao.buscaTodos()}")
        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }

    }
}