export interface pokemonsDTO {
    count: number;
    next: string | null;
    previous: string | null;
    results: pokemonslistDTO[];
}

export interface pokemonslistDTO {
    name: string;
    url: string;
}

export interface PokemonDetailDto {
    id: number;
    name: string;
    types: PokemonDetailListTypeDto[];
    sprites: PokemonDetailSpritesDto;
}
export interface PokemonDetailListTypeDto {
    slots: number;
    type: PokemonDetailTypeDto;
}
export interface PokemonDetailTypeDto {
    name: string;
    url: string;

}
export interface PokemonDetailSpritesDto {
    font_default: string;
    font_shiny: string;
}