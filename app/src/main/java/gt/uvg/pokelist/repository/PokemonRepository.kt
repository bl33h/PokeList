/*---------------------------------------------------------------------------
Copyright (C), 2022-2023, Sara Echeverria (bl33h)
@author Sara Echeverria
FileName: PokemonRepository
@version: I - Kotlin
Creation: 29/09/2022
Last modification: 30/09/2022
------------------------------------------------------------------------------*/
package gt.uvg.pokelist.repository

// Imports
import android.util.Log
import gt.uvg.pokelist.model.Pokemon
import gt.uvg.pokelist.model.GetPokemons
import gt.uvg.pokelist.model.PokeAPI
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import gt.uvg.pokelist.view.PokemonListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class PokemonRepository
{
    val pokemonList = mutableListOf<Pokemon>(Pokemon(1, "bulbasaur"))
    // Pokemon list creation
    fun getPokemonList(adapter:PokemonListAdapter): List<Pokemon>
    {
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        // Retrofit implementation
        val pokeService: PokeAPI = retrofit.create(PokeAPI::class.java)

        // Conditionals for the API response
        if(pokemonList.size == 1){
            pokeService.get100Pokemon().enqueue(object: Callback<GetPokemons>
            {
                override fun onResponse(call: Call<GetPokemons>, response: Response<GetPokemons>)
                {
                    Log.i("API resp", response.toString())
                    // Successful case
                    if(!response.isSuccessful){ return }
                    val body = response.body()!!
                    var i: Int = 1
                    pokemonList.removeAt(0)
                    for(pokemon in body.results)
                    {
                        pokemonList.add(Pokemon(i++, pokemon.name))
                    }
                    adapter.notifyDataSetChanged()
                }
                // Throwable
                override fun onFailure(call: Call<GetPokemons>, t: Throwable)
                {
                    Log.i("MainFragment", t.message ?: "Null Message")
                }
            })
        }
        return pokemonList
    }
}

