package br.com.projeto.orgs.extensions

import android.widget.ImageView
import br.com.projeto.orgs.R
import coil.load

fun ImageView.tentaCarregarImagem(url: String? = null){
    load(url){
        error(R.drawable.erro)
        placeholder(R.drawable.loading)
    }
}