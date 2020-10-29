package br.com.heiderlopes.pokedex.data.remote.pokemon.api

import br.com.heiderlopes.pokedex.data.remote.pokemon.viewModel.PokemonResponseRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    @GET("/api/v2/pokemon/{id}")
    fun pesquisar( @Path("id") id:String) : Call<PokemonResponseRequest>
}