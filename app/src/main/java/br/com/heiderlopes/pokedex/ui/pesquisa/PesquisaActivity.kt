package br.com.heiderlopes.pokedex.ui.pesquisa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.heiderlopes.pokedex.R
import br.com.heiderlopes.pokedex.domain.entity.Pokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pesquisa.*

class PesquisaActivity : AppCompatActivity(), PesquisaContract.PesquisaView {
    private lateinit var pesquisaPresenter: PesquisaPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)
        pesquisaPresenter = PesquisaPresenter(this)
        btPesquisar.setOnClickListener {
            pesquisaPresenter.pesquisar(etPokemon.text.toString())
        }
    }

    override fun exibePokemon(pokemon: Pokemon) {
        tvNomePokemon.text = pokemon.nome
        Picasso.get().load(pokemon.urlImagem).into(ivPokemon)
    }

    override fun exibeErro(mensagem: String?) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }

    override fun loading() {
        TODO("Not yet implemented")
    }

}