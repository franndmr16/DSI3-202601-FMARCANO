import { Component, OnInit, inject, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PokemonService } from '../../services/pokemon';
import { PokemonDto } from '../../models/pokemon.dto';
import { PokemonCardComponent } from '../../components/molecules/pokemon-card/pokemon-card';

@Component({
  selector: 'app-pokemon-page',
  standalone: true,
  imports: [CommonModule, FormsModule, PokemonCardComponent],
  templateUrl: './pokemon-page.html',
  styleUrl: './pokemon-page.css'
})
export class PokemonPage implements OnInit {
  linksPokemon: PokemonDto[] = [];
  filteredPokemon: PokemonDto[] = [];
  selectedPokemon: PokemonDto | null = null;
  searchTerm: string = ''; 
  offset: number = 0;
  limit: number = 20;

  private pokemonService = inject(PokemonService);
  private cdr = inject(ChangeDetectorRef);

  ngOnInit(): void {
    this.loadPokemons();
  }

  loadPokemons(): void {
    this.pokemonService.getPokemons(this.offset, this.limit).subscribe({
      next: (result) => {
        this.linksPokemon = [...result];
        this.filteredPokemon = [...result];
        this.refreshUI();
      },
      error: (err) => console.error('Error:', err)
    });
  }

  searchPokemon(): void {
    const term = this.searchTerm.trim().toLowerCase();

    if (!term) {
      this.filteredPokemon = [...this.linksPokemon];
      return;
    }
    this.pokemonService.getPokemonDetails(term).subscribe({
      next: (pokemon) => {
        if (pokemon) {
          this.filteredPokemon = [pokemon];
          this.selectedPokemon = pokemon; 
          this.refreshUI();
        }
      },
      error: (err) => {
        console.error('No se encontró el Pokémon:', err);
        this.filteredPokemon = [];
        this.refreshUI();
      }
    });
  }

  nextPage(): void {
    this.offset += this.limit;
    this.searchTerm = ''; 
    this.loadPokemons();
  }

  prevPage(): void {
    if (this.offset > 0) {
      this.offset -= this.limit;
      this.searchTerm = '';
      this.loadPokemons();
    }
  }

  selectPokemon(pokemon: PokemonDto): void {
    this.selectedPokemon = pokemon;
  }

  private refreshUI(): void {
    setTimeout(() => {
      this.cdr.markForCheck();
      this.cdr.detectChanges();
    }, 0);
  }
}