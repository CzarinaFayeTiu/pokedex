package ph.edu.dlsu.mobdeve.tiu.czarina.pokedex2021.models

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class Pokemon {

    @SerializedName("name") // this is the json value; its like the id in key-value pair structure of json
    var name = ""
    @SerializedName("url")
    var url = ""

    constructor(name:String, url:String){
        this.name = name
        this.url = url
    }

    class PokemonListResponse{
        //serializedName should be the same as what is in the JSON file of the api
        // see link: https://pokeapi.co/api/v2/pokemon?limit=0&offset=100
        @SerializedName("count")
        var count:Int = -1

        @SerializedName("next")
        var next:String = ""

        @SerializedName("previous")
        var previous:String = ""

        //map automatically
        @SerializedName("results")
        var pokemonList: ArrayList<Pokemon> = ArrayList<Pokemon>()



    }
}