package br.com.heiderlopes.pokedex.ui.pesquisa

import br.com.heiderlopes.pokedex.data.remote.pokemon.api.ApiService
import br.com.heiderlopes.pokedex.data.repositories.PokemonRepositoryImpl

class PesquisaPresenter(
    val pesquisaView: PesquisaContract.PesquisaView

) : PesquisaContract.PesquisaPresenter {
    override fun pesquisar(id: String) {
        val repoPoke = PokemonRepositoryImpl(ApiService.instance);

        repoPoke.pesquisar(
            id,
            {
                pesquisaView.exibePokemon(it)
            },
            {
                pesquisaView.exibeErro(it.message)
            }
        );
    }
}