/*---------------------------------------------------------------------------
Copyright (C), 2022-2023, Sara Echeverria (bl33h)
@author Sara Echeverria
FileName: PokemonListAdapter
@version: I - Kotlin
Creation: 29/09/2022
Last modification: 30/09/2022
------------------------------------------------------------------------------*/

package gt.uvg.pokelist.view

// Imports
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.databinding.ItemPokemonViewBinding
import gt.uvg.pokelist.model.Pokemon

class PokemonListAdapter(private val pokemonList: List<Pokemon>) : RecyclerView.Adapter<PokemonListAdapter.PokemonListHolder>()
{
    inner class PokemonListHolder(val binding: ItemPokemonViewBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListHolder {
        val binding = ItemPokemonViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonListHolder(binding)
    }
    // Gets and sets every item for each pokemon object + Picasso
    override fun onBindViewHolder(holder: PokemonListHolder, position: Int)
    {
        val item = pokemonList[position]
        holder.binding.pokemonName.text = item.name
        Picasso.get().load(item.imageUrlFront).into(holder.binding.pokemonPhoto)

        val action = MainFragmentDirections.actionMainFragmentToDetailFragment(item)
        holder.binding.root.setOnClickListener{
            holder.itemView.findNavController().navigate(action)
        }
    }
    override fun getItemCount(): Int
    {
        return pokemonList.size
    }
}