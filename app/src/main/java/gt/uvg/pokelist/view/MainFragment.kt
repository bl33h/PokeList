/*---------------------------------------------------------------------------
Copyright (C), 2022-2023, Sara Echeverria (bl33h)
@author Sara Echeverria
FileName: MainFragment
@version: I - Kotlin
Creation: 29/09/2022
Last modification: 30/09/2022
------------------------------------------------------------------------------*/
package gt.uvg.pokelist.view

// Imports
import gt.uvg.pokelist.model.GetPokemons
import gt.uvg.pokelist.model.PokeAPI
import gt.uvg.pokelist.model.Pokemon
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import gt.uvg.pokelist.R
import gt.uvg.pokelist.repository.PokemonRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainFragment : Fragment()
{
    // View creation for the container
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
    // View creation for the attributes using the adapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val repository = PokemonRepository()
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        val adapter = PokemonListAdapter(repository.pokemonList)
        recyclerView.adapter = adapter
        // Gets pokemon list using the functions from the PokemonRepository file
        val pokemonList = repository.getPokemonList(adapter)

        recyclerView.addItemDecoration(
            DividerItemDecoration(
                view.context,
                DividerItemDecoration.VERTICAL
            )
        )
    }
}