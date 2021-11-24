package ph.edu.dlsu.mobdeve.tiu.czarina.pokedex2021

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ph.edu.dlsu.mobdeve.tiu.czarina.pokedex2021.PokemonAdapter.*
import ph.edu.dlsu.mobdeve.tiu.czarina.pokedex2021.databinding.ItemPokemonListRowBinding
import ph.edu.dlsu.mobdeve.tiu.czarina.pokedex2021.models.Pokemon


class PokemonAdapter (private val context: Context,
                     private var pokemonlist: ArrayList<Pokemon>)
    :RecyclerView.Adapter<ViewHolder>(){

    // this identifies what layout the pokemon adapter will use for each row
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemPokemonListRowBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    // will tell adapter how many rows
    override fun getItemCount() = pokemonlist.size

    //this binds all the content in a row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(pokemonlist[position])

        holder.btn_view_data.setOnClickListener{
            Log.d("Pokemon", "${pokemonlist[position].name}")

            Intent().also{
                Log.d("Pokemon", "${pokemonlist[position].url}")
                it.action = "ph.edu.dlsu.android.api.broadcast.LOADIMAGEACTION"
                it.putExtra("data", pokemonlist[position].url)
                context.sendBroadcast(it)
            }
        }
    }

    fun setList(pokemonlist:ArrayList<Pokemon>){
        this.pokemonlist.clear()
        this.pokemonlist.addAll(pokemonlist)
        notifyDataSetChanged()
    }
    class ViewHolder(private val itemBinding:ItemPokemonListRowBinding)
        : RecyclerView.ViewHolder(itemBinding.root) {

        public var btn_view_data =itemBinding.btnViewData

        fun bindItems(pokemon: Pokemon) {
            //in item_pokemon_list_row.xml we created pokemon name and btn view data
            itemBinding.pokemonName.text = pokemon.name

        }
    }
}