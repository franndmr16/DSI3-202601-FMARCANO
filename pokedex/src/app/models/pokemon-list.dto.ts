export interface PokemonListResponseDto {
  count: number;
  next: string | null;
  previous: string | null;
  results: PokemonBasicDto[];
}

export interface PokemonBasicDto {
  name: string;
  url: string;
}   