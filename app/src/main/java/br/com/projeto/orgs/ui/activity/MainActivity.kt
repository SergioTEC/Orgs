package br.com.projeto.orgs.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.service.controls.actions.FloatAction
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.projeto.orgs.R
import br.com.projeto.orgs.model.Produto
import br.com.projeto.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.adapter = ListaProdutosAdapter(
            context = this, produtos = listOf(
                Produto(
                    nome = "Cesta de Frutas",
                    descricao = "Banana, pera, uva",
                    valor = BigDecimal("10.87")
                ),

                Produto(
                    nome = "Cesta de Frutas 2",
                    descricao = "Melancia, abacate, morango",
                    valor = BigDecimal("14.67")
                ),

                Produto(
                    nome = "Cesta de Frutas 3",
                    descricao = "Mamao, abacaxi, banana",
                    valor = BigDecimal("14.67")
                )
            )
        )
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }

    }
}