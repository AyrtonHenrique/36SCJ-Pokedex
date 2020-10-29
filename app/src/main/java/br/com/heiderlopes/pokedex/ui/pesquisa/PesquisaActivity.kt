package br.com.heiderlopes.pokedex.ui.pesquisa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.heiderlopes.pokedex.R
import br.com.heiderlopes.pokedex.data.remote.pokemon.api.ApiService
import br.com.heiderlopes.pokedex.data.repositories.PokemonRepositoryImpl
import br.com.heiderlopes.pokedex.domain.repositories.PokemonRepository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pesquisa.*

class PesquisaActivity : AppCompatActivity() {

    private lateinit var pokemonRepository: PokemonRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)
        val poke = ApiService.instance;

        pokemonRepository = PokemonRepositoryImpl(ApiService.instance)

        btPesquisar.setOnClickListener {
            pokemonRepository.pesquisar(
                etPokemon.text.toString(),
                { pokemon ->
                    tvNomePokemon.text = pokemon?.nome
                    Picasso.get()
                        .load(pokemon?.urlImagem)
                        .into(ivPokemon)
                }, {
                    Toast.makeText(this@PesquisaActivity,"Pokémon não encontrado", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}