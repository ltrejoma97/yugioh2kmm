//
//  ListView.swift
//  iosApp
//
//  Created by Camila Juliao on 24/8/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Kingfisher

struct ListScreen: View {
    
    @ObservedObject var viewModel = ListViewModel()
    let gridForm = [GridItem(.flexible())]

    var body: some View {
     
        VStack {
            
            ScrollView{
                
                Text("CARD LIST")
                    .font(.title3)
                    .foregroundColor(.black)
                    .bold()
                    .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .leading)
                    .padding(.top)
                

                LazyVGrid(columns: gridForm, spacing: 8){
                    ForEach(viewModel.yugiohCardsInfo, id: \.self){
                        cards in
                        
                        Button(action: {
                            print("pulse la carta \(cards.name)")
                        }, label: {
                            
                            VStack(spacing: 0) {
                                
                                Text("\(cards.name)")
                                    .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .leading)
                                    .background(Color("Blue-gray"))
                                
                                ForEach(cards.card_images, id: \.self){
                                        images in
                                    KFImage(URL(string: images.image_url))
                                        .resizable()
                                        .scaledToFit()
                                        .frame(width: 240, height: 400)
                                       
                                }
                            }
                            
                        })
                        
                    }
                }

            }
        }.frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .center)
            .padding(.horizontal)
        
//        NavigationLink(
//            destination: DetailView(),
//            isActive: viewModel.$isImageActive,
//            label: {
//                EmptyView()
//            })
      
    }
}


#Preview {
    ListScreen()
}
