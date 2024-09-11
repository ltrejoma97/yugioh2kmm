//
//  PokemonInfo.swift
//  iosApp
//
//  Created by Camila Juliao on 26/8/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation

struct YugiohCardsInfo: Codable {
    var data: [YugiohCards]
}

struct YugiohCards: Codable, Hashable{
    var id: Int
    var name: String
    var type: String
    var frameType: String
    var desc: String
    var race: String
    var card_images: [CardImages1]
}

struct CardImages1: Codable, Hashable{
    var id: Int
    var image_url: String
    var image_url_small: String
    var image_url_cropped: String
}
