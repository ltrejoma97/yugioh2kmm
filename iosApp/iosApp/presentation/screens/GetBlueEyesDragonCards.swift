//
//  PostScreen.swift
//  iosApp
//
//  Created by Camila Juliao on 5/9/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Shared
import Kingfisher

struct GetBlueEyesDragonCardsScreen: View {
    @StateObject var viewModel = GetBlueEyesDragonCardsViewModel()
    
    var body: some View {
        ScrollView{
            VStack(spacing: 10){
                if(!viewModel.blueEyesDragons.data.isEmpty){
                    ForEach(viewModel.blueEyesDragons.data, id: \.self){ cards in
                        Button(action: {}, label: {
                            VStack(spacing: 0) {
                                Text("\(cards.name)")
                                    .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .leading)
                                    .background(Color("Blue-gray"))
                                
                                
                                ForEach(cards.card_images, id: \.self){ images in
                                    KFImage(URL(string: images.image_url))
                                        .resizable()
                                        .scaledToFit()
                                        .frame(width: 240, height: 400)
                                }
                            }
                        })
                    }
                }
            }.task { await viewModel.getBlueEyesDragons() }
        }
    }
}
  



#Preview {
    GetBlueEyesDragonCardsScreen()
}
