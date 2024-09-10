//
//  PostScreen.swift
//  iosApp
//
//  Created by Camila Juliao on 5/9/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Shared

struct GetBlueEyesDragonCardsScreen: View {
    @StateObject var viewModel = GetBlueEyesDragonCardsViewModel()
    
    var body: some View {
        ScrollView{
            VStack(spacing: 10){
//                ForEach(viewModel.blueEyesDragons, id: \.id){ cards in
//
//                    
//                }
                Text("\(viewModel.blueEyesDragons)")
                
            }
        }
    }
}

#Preview {
    GetBlueEyesDragonCardsScreen()
}
