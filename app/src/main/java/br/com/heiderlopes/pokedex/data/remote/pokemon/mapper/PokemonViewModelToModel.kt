package br.com.heiderlopes.pokedex.data.remote.pokemon.mapper

import br.com.heiderlopes.pokedex.data.remote.pokemon.viewModel.PokemonResponseRequest
import br.com.heiderlopes.pokedex.domain.entity.Pokemon

object PokemonViewModelToModel {
    fun map(pokemons: List<PokemonResponseRequest>) = pokemons.map { map(it) }

    fun map(pokemon: PokemonResponseRequest) = Pokemon(
        pokemon.nome,
        pokemon.sprites.other.officialArtWork.frontDefault
    )
}