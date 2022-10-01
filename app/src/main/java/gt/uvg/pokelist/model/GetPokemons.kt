/*---------------------------------------------------------------------------
Copyright (C), 2022-2023, Sara Echeverria (bl33h)
@author Sara Echeverria
FileName: GetPokemons
@version: I - Kotlin
Creation: 29/09/2022
Last modification: 29/09/2022
------------------------------------------------------------------------------*/
package gt.uvg.pokelist.model

// Attributes
data class GetPokemons(
    val count: Int = 0,
    val next: String = "",
    val previous: String? = "",
    val results: List<NamedAPIResource> = listOf()
){
    data class NamedAPIResource(
        val name: String,
        val url: String
    )
}
