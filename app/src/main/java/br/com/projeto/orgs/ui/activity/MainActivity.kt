package br.com.projeto.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import br.com.projeto.orgs.R
import br.com.projeto.orgs.ui.recyclerview.adapter.ListaProdutosAdapter

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val nome = findViewById<TextView>(R.id.nome)
//        nome.text = ("Cesta de Frutas")
//        val descricao = findViewById<TextView>(R.id.descricao)
//        descricao.text = ("Laranja, manga e banana")
//        val valor = findViewById<TextView>(R.id.valor)
//        valor.text = ("12.59")
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaProdutosAdapter()

    }
}