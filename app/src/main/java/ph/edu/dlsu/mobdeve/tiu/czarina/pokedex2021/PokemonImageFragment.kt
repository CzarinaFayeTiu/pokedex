package ph.edu.dlsu.mobdeve.tiu.czarina.pokedex2021

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import ph.edu.dlsu.mobdeve.tiu.czarina.pokedex2021.databinding.FragmentPokemonImageBinding
import ph.edu.dlsu.mobdeve.tiu.czarina.pokedex2021.databinding.FragmentPokemonListBinding

class PokemonImageFragment : Fragment() {

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            var imageUrl: String? = intent!!.getStringExtra("data")

            //picasso will load image from internet
            imageUrl?.let {
                Picasso
                    .with(activity!!.applicationContext)
                    .load(it)
                    .memoryPolicy(MemoryPolicy.NO_CACHE)
                    .placeholder(R.drawable.pokemon_egg)
                    .error(R.drawable.pokemon_egg)
                    .into(binding!!.pokemonImage)
            }
        }
    }

    var binding:FragmentPokemonImageBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupReceiver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPokemonImageBinding.inflate(inflater, container, false)
        var view = binding!!.root
        return view
    }

    override fun onDestroyView() {
        requireActivity().unregisterReceiver(receiver)
        super.onDestroyView()
    }
    private fun setupReceiver(){
        val intentFilter = IntentFilter()
        intentFilter.addAction("ph.edu.dlsu.android.api.broadcast.LOADIMAGEACTION")
        requireActivity().registerReceiver(receiver, intentFilter)
    }
}