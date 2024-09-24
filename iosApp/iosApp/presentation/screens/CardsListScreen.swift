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
    let gridForm = [GridItem(.flexible()), GridItem(.flexible()), GridItem(.flexible())]
    
    var body: some View {
    NavigationView{
        ScrollView{
            VStack(){
                Text("Yugioh Card List")
                        .font(.custom("Courier" ,size: 25))
                        .foregroundColor(.black)
                        .bold()
                        .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .leading)
                        .padding([.top, .bottom])
                LazyVGrid(columns: gridForm, spacing: 10){
//                    if(!$viewModel.blueEyesDragonsCards.){
//                        ForEach(viewModel.blueEyesDragonsCards.data, id: \.self){ cardDescription in
//                            CardsListDetail(viewModel: viewModel,
//                                            card: cardDescription)
//                        }
//                    }
                }
            }
            .task { await viewModel.getBlueEyesDragons()
                    await viewModel.readTestRealmHlelper()
            }
        }.padding(.horizontal, 10)
    }
    }
    
    
    struct CardsListDetail: View {
        var viewModel: CardsListViewModel
        var card: CardDto
        @State var isActive: Bool = false
        
        var body: some View {
            NavigationLink(destination: WorldScreen(card: card), isActive: $isActive){
                Button(action: {isActive = true}, label: {
                    
                    
                    if(card.card_images.count > 1){
                        
                        VStack(spacing: 0) {
                            Text("\(card.name)")
                                .font(.custom("Courier" ,size: 8))
                                .foregroundColor(Color.black)
                                .lineLimit(3)
                            KFImage(URL(string: card.card_images[0].image_url))
                                .resizable()
                                .scaledToFit()
                                .frame(width: 110, height: 190
                                )
                        }.padding(.horizontal, 10)
                        
                    }else{
                        VStack(spacing: 0) {
                            Text("\(card.name)")
                                .font(.custom("Courier" ,size: 10))
                                .foregroundColor(Color.black)
                                .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity,maxHeight: 20 ,alignment: .center)
                                .lineLimit(3)
                            ForEach(card.card_images, id: \.self){ images in
                                
                                KFImage(URL(string: images.image_url))
                                    .resizable()
                                    .scaledToFit()
                                    .frame(width: 110, height: 190
                                    )
                            }
                        }.padding(.horizontal, 10)
                    }
                })
            }
        }
    }
}




  



#Preview {
    CardsListScreen()
}
