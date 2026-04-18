export interface PokemonsDTO{
    count: Number;
    next: String;
    previous: String | null;
    results: PokemonsListDTO[];
}

export interface PokemonsListDTO{
    name: String;
    url: String;
}

export interface PokemonDetailDTO{
    name: String;
}

export interface PokemonDetailDTOListTypeDTO{
    slot: number;
}

export interface PokemonDetailTypeDTO{
    name: String
    url: String
}