package br.com.projeto.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.projeto.orgs.R
import br.com.projeto.orgs.model.Produto
import br.com.projeto.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val nome = findViewById<TextView>(R.id.nome)
//        nome.text = "Cesta de frutas"
//        val descricao = findViewById<TextView>(R.id.descricao)
//        descricao.text = "Laranja, manga e uva"
//        val valor = findViewById<TextView>(R.id.valor)
//        valor.text = "19.99"
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
    }
}