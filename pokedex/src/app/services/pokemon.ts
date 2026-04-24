import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, forkJoin } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';
import { PokemonDto } from '../models/pokemon.dto';
import { PokemonListResponseDto } from '../models/pokemon-list.dto';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {
  private readonly http = inject(HttpClient);
  private readonly BASE_URL = 'https://pokeapi.co/api/v2/';
  private readonly POKEMON_PATH = 'pokemon';

  getPokemons(offset: number = 0, limit: number = 20): Observable<PokemonDto[]> {
    return this.http.get<PokemonListResponseDto>(`${this.BASE_URL}${this.POKEMON_PATH}?limit=${limit}&offset=${offset}`)
      .pipe(
        switchMap(response => {
          const detailRequests = response.results.map(pokemon => 
            this.getPokemon(pokemon.name)
          );
          return forkJoin(detailRequests);
        })
      );
  }

  getPokemon(name: string): Observable<PokemonDto> {
    return this.http.get<PokemonDto>(`${this.BASE_URL}${this.POKEMON_PATH}/${name}`);
  }
}