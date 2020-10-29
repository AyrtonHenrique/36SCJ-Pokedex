package br.com.heiderlopes.pokedex.ui.pesquisa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.heiderlopes.pokedex.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pesquisa.*

class PesquisaActivity : AppCompatActivity() {
    private lateinit var pesquisaViewModel: PesquisaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)

        pesquisaViewModel = ViewModelProvider(this).get(PesquisaViewModel::class.java)
        btPesquisar.setOnClickListener {
            pesquisaViewModel.pesquisar(etPokemon.text.toString())
        }

        pesquisaViewModel.pokemonResponse.observe(this, Observer {
            tvNomePokemon.text = it.nome;
            Picasso.get().load(it.urlImagem).into(ivPokemon)
        })

        pesquisaViewModel.mensagemErroResponse.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}