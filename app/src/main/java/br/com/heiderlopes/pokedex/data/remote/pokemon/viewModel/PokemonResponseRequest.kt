package br.com.heiderlopes.pokedex.data.remote.pokemon.viewModel

import com.google.gson.annotations.SerializedName

data class PokemonResponseRequest (
    @SerializedName("name")  val nome: String,
    val sprites:Sprites
)

data class Sprites(
    @SerializedName("front_default") val frontDefault: String,
    val other: SpritesOther
)

data class  SpritesOther(
    @SerializedName("dream_world") val dreamWorld:SpritesOtherDreamWorld,
    @SerializedName("official-artwork") val officialArtWork: SpritesOfficialArtWork
)

data class SpritesOtherDreamWorld(
    @SerializedName("front_default") val frontDefault:String
)

data class  SpritesOfficialArtWork(
    @SerializedName("front_default") val frontDefault:String
)