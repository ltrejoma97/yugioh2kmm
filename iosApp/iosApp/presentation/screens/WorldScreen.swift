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
    var name: String
    var card_images: [CardImages]
    var atk: Int32
    var def: Int32

    var body: some View {
    
        VStack {
            if(card_images.count > 1){
                
                VStack(spacing: 0) {
                    Text("\(name)")
                        .font(.custom("Courier" ,size: 20))
                        .foregroundColor(Color.black)
                        .lineLimit(3)
                    KFImage(URL(string: card_images[0].image_url))
                        .resizable()
                        .scaledToFit()
                        .frame(width: 340, height: 430
                        )
                }.padding(.horizontal, 10)
                
            }else{
                VStack(spacing: 0) {
                    Text("\(name)")
                        .font(.custom("Courier" ,size: 20))
                        .foregroundColor(Color.black)
                        .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity,maxHeight: 20 ,alignment: .center)
                        .lineLimit(3)
                    ForEach(card_images, id: \.self){ images in
                        
                        KFImage(URL(string: images.image_url))
                            .resizable()
                            .scaledToFit()
                            .frame(width: 340, height: 430
                            )
                    }
                }.padding(.horizontal, 10)
            }
    
        }
    }
}

//#Preview {
//    WorldScreen()
//}

