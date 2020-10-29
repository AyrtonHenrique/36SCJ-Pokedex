package br.com.heiderlopes.pokedex.domain.repositories

import br.com.heiderlopes.pokedex.data.remote.pokemon.viewModel.PokemonResponseRequest
import br.com.heiderlopes.pokedex.domain.entity.Pokemon

interface PokemonRepository {

    fun pesquisar(id: String,
                  onComplete: (Pokemon) -> Unit,
                  onError: (Throwable) -> Unit)
}