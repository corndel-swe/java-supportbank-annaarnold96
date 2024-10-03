package com.corndel.supportbank.exercises;

// import kong.unirest.Unirest;

// import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.Unirest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This class represents a Pokemon. It uses Java's record syntax to
 * automatically generate a class with getters and utility methods.
 * See this url for more info:
 * https://www.baeldung.com/java-record-keyword
 */
@JsonIgnoreProperties(ignoreUnknown = true)
record Pokemon(Integer id, String name, Integer height, Integer weight) {
}

public class PokeAPI {
  /**
   * Get a Pokemon by its name.
   *
   * Makes a GET request to the PokeAPI, and uses Jackson to parse the JSON
   * response into a Pokemon object.
   *
   * @param name The name of the Pokemon to retrieve.
   * @return The Pokemon object.
   */
  public static Pokemon getPokemonByName(String name) throws Exception {
    // TODO: Create the url by appending the name to the base url
    String url = "https://pokeapi.co/api/v2/pokemon/" + name;
    // TODO: Make a GET request to the url
    // Hint: Use Unirest.get()
    var response = Unirest.get(url).header("Accept", "application/json").asString();
    // TODO: Parse the response body into a Pokemon object
    // Hint: Use Jackson's ObjectMapper to map the response body to Pokemon.class
    String json = response.getBody();
    ObjectMapper mapper = new ObjectMapper();
      // TODO: Return the Pokemon
    return mapper.readValue(json, Pokemon.class);
  }

  public static JsonNode getPokemonByID(String id) throws Exception {
    // TODO: Create the url by appending the name to the base url
    String url = "https://pokeapi.co/api/v2/pokemon/" + id;
    // TODO: Make a GET request to the url
    // Hint: Use Unirest.get()
    var response = Unirest.get(url).header("Accept", "application/json").asString();
    // TODO: Parse the response body into a Pokemon object
    // Hint: Use Jackson's ObjectMapper to map the response body to Pokemon.class
    String json = response.getBody();
    ObjectMapper mapper = new ObjectMapper();
      // TODO: Return the Pokemon
    var pokemonReadValue = mapper.readValue(json, Pokemon.class);
    var pokemonTree = mapper.readTree(json);
    return pokemonTree;
  }

  /**
   * For debugging purposes..
   */
//  public static void main(String[] args) {
//    try {
//      Pokemon pokemon = getPokemonByName("pikachu");
//      System.out.println(pokemon);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//}

public static void main(String[] args) {
  List listOfPokemon = new ArrayList<>();

  int lengthOfList = 10;

  try {
    for (var i = 0; i < lengthOfList; i++) {
      Random rand = new Random();
      int n = rand.nextInt(1000);
      JsonNode pokemon = getPokemonByID(String.valueOf(n+1));
      listOfPokemon.add("#" + pokemon.get("id") + ": " + pokemon.get("name"));
    }
    }

  catch(Exception e){
    e.printStackTrace();
  }
  System.out.println("ID : Name\n"+ "-".repeat(10));

  for (Object i : listOfPokemon){
    System.out.println(i);}
  }
}

