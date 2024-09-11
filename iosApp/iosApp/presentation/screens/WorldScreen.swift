//
//  WorldView.swift
//  iosApp
//
//  Created by Camila Juliao on 24/8/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Shared

struct WorldScreen: View {
    
    var isImageActive: Bool
    var atk: Int32
    var def: Int32
    var id: Int32
    var name: String
    var type: String
    var desc: String
    var race: String
    var card_images: [CardImages]
    
    
    var body: some View {
    
        VStack {
            Text(name)
    
        }
    }
}

//#Preview {
//    WorldScreen()
//}

