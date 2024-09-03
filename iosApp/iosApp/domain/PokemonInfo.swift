//
//  PokemonInfo.swift
//  iosApp
//
//  Created by Camila Juliao on 26/8/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation

struct PokemonInfo: Codable {
    var data: [Pokemons]
}

struct Pokemons: Codable{
    var id: Int
    var name: String
    var type: String
    var frameType: String
    var desc: String
    var race: String
}

struct CardImages: Codable{
    var id: Int
    var image_url: String
}
