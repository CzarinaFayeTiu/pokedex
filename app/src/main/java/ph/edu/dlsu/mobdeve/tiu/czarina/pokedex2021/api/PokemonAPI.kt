package ph.edu.dlsu.mobdeve.tiu.czarina.pokedex2021.api

import ph.edu.dlsu.mobdeve.tiu.czarina.pokedex2021.models.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonAPI {
    @GET("pokemon/") // this is the list of pokemon
    fun getList(
        //this is related to the url for the api - ito yun mga ipapass na value
        //url: https://pokeapi.co/api/v2/pokemon?limit=0&offset=100
        @Query("offset") startIndex:Int,
        @Query("limit") Limit:Int)
            :Call<Pokemon.PokemonListResponse>
    }
