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


struct CardsListScreen: View {
@StateObject var viewModel = CardsListViewModel()
    var body: some View {
    NavigationView{
        ScrollView{
            VStack(spacing: 10){
                Text(viewModel.readPaddintong)
                        .font(.title)
                        .foregroundColor(.black)
                        .bold()
                        .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .leading)
                        .padding([.top, .leading, .bottom])
                
                    if(!viewModel.blueEyesDragonsCards.data.isEmpty){
                        ForEach(viewModel.blueEyesDragonsCards.data, id: \.self){ cards in
                            CardsListDetail(viewModel: viewModel, 
                                            name: cards.name,
                                            card_images: cards.card_images)
                        }
                    }
            }.task { await viewModel.getBlueEyesDragons()
                
                await viewModel.readTestRealmHlelper()
            }
        }
    }
    }
    
    
    struct CardsListDetail: View {
        var viewModel: CardsListViewModel
        var name: String
        var card_images: [CardImages]
        
        var body: some View {
            Button(action: {viewModel.isImageActive = true}, label: {
                VStack(spacing: 0) {
                    Text("\(name)")
                            .foregroundColor(Color.black)
                            .padding(.leading)
                            .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .leading)
                        
                    ForEach(card_images, id: \.self){ images in
                            KFImage(URL(string: images.image_url))
                                .resizable()
                                .scaledToFit()
                                .frame(width: 240, height: 400
                      )
                   }
                }
            })
        }
    }
}




  



#Preview {
    CardsListScreen()
}
