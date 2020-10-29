package br.com.heiderlopes.pokedex.ui.pesquisa

import br.com.heiderlopes.pokedex.domain.entity.Pokemon

interface PesquisaContract {

    interface PesquisaView {
        fun exibePokemon(pokemon: Pokemon)
        fun exibeErro(mensagem: String?)
        fun loading()
    }

    interface PesquisaPresenter {
        fun pesquisar(id: String)
    }
}