export interface PokemonDto {
  id: number;
  name: string;
  height: number;
  weight: number;
  base_experience: number;
  sprites: SpritesDto;
  types: PokemonTypeSlotDto[];
  stats: PokemonStatSlotDto[];
}
export interface SpritesDto {
  front_default: string;
  other: {
    'official-artwork': {
      front_default: string;
    };
  };
}
export interface PokemonTypeSlotDto {
  slot: number;
  type: {
    name: string;
    url: string;
  };
}
export interface PokemonStatSlotDto {
  base_stat: number;
  stat: {
    name: string;
    url: string;
  };
}
export interface PokemonListResponseDto {
  count: number;
  next: string | null;
  previous: string | null;
  results: {
    name: string;
    url: string;
  }[];
}