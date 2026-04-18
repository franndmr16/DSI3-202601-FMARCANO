import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PokemonsDTO } from '../models/model';

@Injectable({
  providedIn: 'root',
})
export class PokemonService{
  private readonly BASE_URL = "https://pokeapi.co/api/v2";
  private readonly POKEMON_PATH = "/pokemon";

  constructor(private http: HttpClient){}
  
  getPokemons(offset: number = 0, limit: number = 20): Observable<PokemonsDTO>{
    return this.http.get<PokemonsDTO>(`${this.BASE_URL}${this.POKEMON_PATH}?offset=${offset}&limit=$
  }
}
    
