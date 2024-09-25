//
//  WorldView.swift
//  iosApp
//
//  Created by Camila Juliao on 24/8/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Shared
import Kingfisher

struct WorldScreen: View {
    var card: YugiohCard

    var body: some View {
    
//        VStack {
 
        VStack(spacing: 0) {
            Text("\(card.name)")
             .font(.custom("Courier" ,size: 20))
             .foregroundColor(Color.black)
             .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity,maxHeight: 20 ,alignment: .center)
             .lineLimit(3)
                    
     
            KFImage(URL(string: card.imgUrl))
              .resizable()
              .scaledToFit()
              .frame(width: 300, height: 400)
            
            ZStack{
                RoundedRectangle(cornerRadius: 8)
                    .fill(Color("yugioh_brown"))
                    .frame(width: 340)
                
                Image("yugioh_card")
                    .resizable()
                    .scaledToFit()
                    .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity,alignment: .trailing)
            
                
                VStack{
                    Text("Atk: \(card.atk)")
                        .font(.custom("Courier", size: 20))
                        .foregroundColor(Color.white)
                        .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .leading)
                        .padding(.vertical, 4)
                    Text("Def: \(card.def)")
                        .font(.custom("Courier", size: 20))
                        .foregroundColor(Color.white)
                        .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .leading)
                        .padding(.vertical, 4)
                    Text("Level: \(card.level)")
                        .font(.custom("Courier", size: 20))
                        .foregroundColor(Color.white)
                        .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .leading)
                        .padding(.vertical, 4)
                    Text("Race: \(card.race)")
                        .font(.custom("Courier", size: 20))
                        .foregroundColor(Color.white)
                        .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .leading)
                        .padding(.vertical, 4)
                    Text("Type: \(card.type)")
                        .font(.custom("Courier", size: 20))
                        .foregroundColor(Color.white)
                        .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .leading)
                        .padding(.vertical, 4)
                }.padding(.horizontal, 20)
    
            }.frame(alignment: /*@START_MENU_TOKEN@*/.center/*@END_MENU_TOKEN@*/)
            .padding(.vertical, 10)
            
        }.padding(.horizontal, 20)
        
        
//            if(card.card_images.count > 1){
                
//                VStack(spacing: 0) {
//                    Text("\(card.name)")
//                        .font(.custom("Courier" ,size: 20))
//                        .foregroundColor(Color.black)
//                        .lineLimit(3)
//                    KFImage(URL(string: card.card_images[0].image_url))
//                        .resizable()
//                        .scaledToFit()
//                        .frame(width: 340, height: 430
//                        )
//                }.padding(.horizontal, 10)
//                
//            }else{
//                VStack(spacing: 0) {
//                    Text("\(card.name)")
//                        .font(.custom("Courier" ,size: 20))
//                        .foregroundColor(Color.black)
//                        .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity,maxHeight: 20 ,alignment: .center)
//                        .lineLimit(3)
//                    ForEach(card.card_images, id: \.self){ images in
//                        
//                        KFImage(URL(string: images.image_url))
//                            .resizable()
//                            .scaledToFit()
//                            .frame(width: 340, height: 430
//                            )
//                    }
//                }.padding(.horizontal, 10)
//            }
    
//        }
    }
}

//#Preview {
//    WorldScreen(CardDto.copy())
//}

