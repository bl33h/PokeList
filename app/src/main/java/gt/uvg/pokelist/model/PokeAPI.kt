/*---------------------------------------------------------------------------
Copyright (C), 2022-2023, Sara Echeverria (bl33h)
@author Sara Echeverria
FileName: PokeAPI
@version: I - Kotlin
Creation: 29/09/2022
Last modification: 29/09/2022
------------------------------------------------------------------------------*/

package gt.uvg.pokelist.model

// Imports
import retrofit2.http.GET
import retrofit2.Call

// API call
interface PokeAPI
{
    @GET("pokemon?limit=100&offset=0")
    fun get100Pokemon(): Call<GetPokemons>
}