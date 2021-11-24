package ph.edu.dlsu.mobdeve.tiu.czarina.pokedex2021

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import ph.edu.dlsu.mobdeve.tiu.czarina.pokedex2021.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val pokemonListFragment = PokemonListFragment()

    private lateinit var appBarConfiguration: AppBarConfiguration
    //Notice that this also use binding
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_holder, pokemonListFragment)
            .commit()

    }
}