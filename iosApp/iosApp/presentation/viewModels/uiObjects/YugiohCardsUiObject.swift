//
//  YugiohCardsUiObject.swift
//  iosApp
//
//  Created by Camila Juliao on 10/9/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import Shared

struct YugiohCardsUiObject: Codable, Hashable{
    var id: Int = 0
    var name: String = ""
    var type: String = ""
    var frameType: String = ""
    var desc: String = ""
    var race: String = ""
    var card_images: [CardImages1] = []
    var isImageActive = false
  
}


