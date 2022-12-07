package br.com.projeto.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.projeto.orgs.R
import br.com.projeto.orgs.dao.ProdutosDao
import br.com.projeto.orgs.databinding.ActivityListaProdutosBinding
import br.com.projeto.orgs.ui.recyclerview.adapter.ListaProdutosAdapter

class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) {

    private val binding by lazy {
        ActivityListaProdutosBinding.inflate(layoutInflater)
    }
    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraRecyclerView()
        configuraFab()
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }

    private fun configuraFab() {
        val fab = binding.activityListaProdutoFab
        fab.setOnClickListener {
            vaiParaFormularioProduto()
        }
    }

    private fun vaiParaFormularioProduto() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerView = binding.activityListaProdutoRecyclerView
        recyclerView.adapter = adapter
        // implementação do listener para abrir a Activity de detalhes do produto
        // com o produto clicado
        adapter.quandoClicaNoItemListener = {
            val intent = Intent(this, DetalhesProdutoActivity::class.java).apply {
                // envio do produto por meio do extra
                putExtra(CHAVE_PRODUTO, it)
            }
            startActivity(intent)
        }
    }
}