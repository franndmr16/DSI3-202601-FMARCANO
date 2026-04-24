import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { forkJoin } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { PokemonDto } from '../models/pokemon.dto';
import { PokemonListResponseDto } from '../models/pokemon-list.dto';

@Injectable({ providedIn: 'root' })
export class PokemonService {
  private BASE_URL = 'https://pokeapi.co/api/v2';
  private readonly POKEMON_PATH = '/pokemon';

  constructor(private http: HttpClient) {}

  getPokemons(offset: number = 0, limit: number = 20): Observable<PokemonDto[]> {
    return this.http.get<PokemonListResponseDto>(${this.BASE_URL}${this.POKEMON_PATH}?limit=${limit}&offset=${offset})
      .pipe(
        switchMap(response => {
          const detailPokemon = response.results.map(pokemon => {
            return this.getPokemon(pokemon.name);
          });
          return forkJoin(detailPokemon);
        })
      );
  }

  getPokemon(name: string): Observable<PokemonDto> {
    return this.http.get<PokemonDto>(${this.BASE_URL}${this.POKEMON_PATH}/${name});
  }
}