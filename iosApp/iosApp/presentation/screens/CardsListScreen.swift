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
import AVKit

struct CardsListScreen: View {
    @StateObject var viewModel = CardsListViewModel()
    var body: some View {
        NavigationView{
            ScrollView{
                VStack(spacing: 10){
                    Text("CARD LIST")
                        .font(.title)
                        .foregroundColor(.black)
                        .bold()
                        .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .leading)
                        .padding([.top, .leading, .bottom])
                    
                    if(!viewModel.blueEyesDragonsCards.data.isEmpty){
                        ForEach(viewModel.blueEyesDragonsCards.data, id: \.self){ cards in
                                Button(action: {
                                    viewModel.atk = cards.atk
                                    viewModel.def = cards.def
                                    viewModel.desc = cards.desc
                                    viewModel.id = cards.id
                                    viewModel.name = cards.name
                                    viewModel.card_images = cards.card_images
                                    viewModel.isImageActive = true
                                    
                                }, label: {
                                    
                                    VStack(spacing: 0) {
                                        Text("\(cards.name)")
                                            .foregroundColor(Color.black)
                                            .padding(.leading)
                                            .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .leading)
                                        
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
//            NavigationLink(destination: WorldScreen(isImageActive: viewModel.isImageActive, atk: viewModel.atk, def: viewModel.def, id: viewModel.id, name: viewModel.name, type: viewModel.type, desc: viewModel.desc, race: viewModel.race, card_images: viewModel.card_images),
//                           isActive: $isImageActive,
//                           label: { EmptyView()})
      
        }
    }
}
  



#Preview {
    CardsListScreen()
}
