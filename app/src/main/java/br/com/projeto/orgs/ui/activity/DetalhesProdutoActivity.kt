package br.com.projeto.orgs.ui.activity

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.projeto.orgs.R
import br.com.projeto.orgs.databinding.ActivityDetalhesProdutoBinding
import br.com.projeto.orgs.extensions.formataParaMoedaBrasileira
import br.com.projeto.orgs.extensions.tentaCarregarImagem
import br.com.projeto.orgs.model.Produto

class DetalhesProdutoActivity : AppCompatActivity(R.layout.activity_detalhes_produto) {

    private val binding by lazy {
        ActivityDetalhesProdutoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        tentaCarregarProduto()
    }

    // tentativa de buscar o produto se ele existir,
    // caso contrário, finalizar a Activity
    private fun tentaCarregarProduto() {
        intent.getParcelableExtra<Produto>(CHAVE_PRODUTO)?.let { produtoCarregado ->
            preencheCampos(produtoCarregado)
        } ?: finish()
    }

    private fun preencheCampos(produtoCarregado: Produto) {
        with(binding) {
            activityDetalhesProdutoImagem.tentaCarregarImagem(produtoCarregado.imagem)
            activityDetalhesProdutoNome.text = produtoCarregado.nome
            activityDetalhesProdutoDescricao.text = produtoCarregado.descricao
            activityDetalhesProdutoValor.text = produtoCarregado.valor.formataParaMoedaBrasileira()
        }
    }
}