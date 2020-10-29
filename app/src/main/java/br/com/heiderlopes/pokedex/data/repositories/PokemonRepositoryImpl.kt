package br.com.heiderlopes.pokedex.data.repositories

import br.com.heiderlopes.pokedex.data.remote.pokemon.api.ApiService
import br.com.heiderlopes.pokedex.data.remote.pokemon.api.PokemonService
import br.com.heiderlopes.pokedex.data.remote.pokemon.mapper.PokemonViewModelToModel
import br.com.heiderlopes.pokedex.data.remote.pokemon.viewModel.PokemonResponseRequest
import br.com.heiderlopes.pokedex.domain.entity.Pokemon
import br.com.heiderlopes.pokedex.domain.repositories.PokemonRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepositoryImpl (
    val pokemonService: PokemonService
): PokemonRepository {
    override fun pesquisar(
        id: String,
        onComplete: (Pokemon) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        pokemonService
            .pesquisar(id)
            .enqueue(object : Callback<PokemonResponseRequest> {
                override fun onFailure(call: Call<PokemonResponseRequest>, t: Throwable) {
                    onError(t)
                }
                override fun onResponse(
                    call: Call<PokemonResponseRequest>,
                    response: Response<PokemonResponseRequest>
                ) {
                    if (response.isSuccessful) {
                        val poke = response.body();
                        if(poke != null){
                            onComplete(PokemonViewModelToModel.map(poke))
                        }else{
                            onError(Throwable("Pokemon não encontrado"))
                        }
                    } else {
                        onError(Throwable("Pokemon não encontrado"))
                    }
                }
            })
    }

}