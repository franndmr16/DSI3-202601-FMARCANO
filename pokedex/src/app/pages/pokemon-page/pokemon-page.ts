import { Component, inject } from '@angular/core';
import { NgFor } from '@angular/common';
import { PokemonDto } from '../../models/pokemon.dto';
import { PokemonService } from '../../services/pokemon';

@Component({
  selector: 'app-pokemon-page',
  imports: [NgFor],
  templateUrl: './pokemon-page.html',
  styleUrl: './pokemon-page.css'
})
export class PokemonPage {
  linksPokemon: PokemonDto[] = [];
  private pokemonService = inject(PokemonService);

  constructor() {
    this.pokemonService.getPokemons().subscribe(result => {
      this.linksPokemon = result;
      console.log('Pokémons cargados:', this.linksPokemon);
    });
  }
}