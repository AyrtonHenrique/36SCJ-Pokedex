package br.com.heiderlopes.pokedex.data.remote.pokemon.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory.create

object ApiService {
     var INSTANCE : PokemonService? = null

    val instance: PokemonService?

    get() {
        if(INSTANCE == null){
            val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/")
                .addConverterFactory(create())
                .build()
            INSTANCE = retrofit.create(
                PokemonService::class.java)
        }
        return INSTANCE
    }
}