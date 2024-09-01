//
//  ListView.swift
//  iosApp
//
//  Created by Camila Juliao on 24/8/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ListView: View {
    private var viewModel: ListViewModel = ListViewModel()

    var body: some View {
     
        VStack {
            
            ScrollView{
                Text("CARD LIST")
                    .font(.title3)
                    .foregroundColor(.black)
                    .bold()
                    .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .leading)
                    .padding(.top)
                
                
                Button(action: {
                    viewModel.isImageActive = true
                    viewModel.name = "Amo de las mentes"
                    viewModel.atk = "100"
                    viewModel.def = "200"
                }, label: {
                    
                    VStack(spacing: 0) {
                        
                        Text("Amo de las mentes")
                            .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .leading)
                            .background(Color("Blue-gray"))
                        
                        Image("Amo_de_las_mentes")
                            .resizable()
                            .scaledToFit()
                            .frame(width: 240, height: 400)
                           
                    }
                    
                })
                
                
                Button(action: {
//                    isImageActive = true
//                    name = "Cadena esoterica"
//                    atk = "700"
//                    def = "700"
                }, label: {
                    
                    VStack(spacing: 0) {
                        
                        Text("Cadena esoterica")
                            .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .leading)
                            .background(Color("Blue-gray"))
                        
                        Image("Cadena_esoterica")
                            .resizable()
                            .scaledToFit()
                            .frame(width: 240, height: 400)

                    }
                    
                })
                
                Button(action: {
//                    isImageActive = true
//                    name = "Chaos king"
//                    atk = "4000"
//                    def = "4000"
                }, label: {
                    
                    VStack(spacing: 0) {
                        
                        Text("Chaos king")
                            .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .leading)
                            .background(Color("Blue-gray"))
                        
                        Image("Chaos_king")
                            .resizable()
                            .scaledToFit()
                            .frame(width: 240, height: 400)
                    }
                    
                })
                
                Button(action: {
//                    isImageActive = true
//                    name = "Kunai con cadena"
//                    atk = "400"
//                    def = "400"
                }, label: {
                    
                    VStack(spacing: 0) {
                        
                        Text("Kunai con cadena")
                            .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .leading)
                            .background(Color("Blue-gray"))
                        
                        Image("Kunai_con_cadena")
                            .resizable()
                            .scaledToFit()
                            .frame(width: 240, height: 400)
                    }
                    
                })
                
                Button(action: {
//                    isImageActive = true
//                    name = "Mago oscuro"
//                    atk = "2500"
//                    def = "2100"
                }, label: {
                    
                    VStack(spacing: 0) {
                        
                        Text("Mago oscuro")
                            .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .leading)
                            .background(Color("Blue-gray"))
                        
                        Image("Mago_oscuro")
                            .resizable()
                            .scaledToFit()
                            .frame(width: 240, height: 400)
                    }
                    
                })
                
                Button(action: {
//                    isImageActive = true
//                    name = "Payaso del sueño"
//                    atk = "1200"
//                    def = "900"
                }, label: {
                    
                    VStack(spacing: 0) {
                        
                        Text("Payaso del sueño")
                            .frame(minWidth: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, maxWidth: .infinity, alignment: .leading)
                            .background(Color("Blue-gray"))
                        
                        Image("Payaso_de_ sueno")
                            .resizable()
                            .scaledToFit()
                            .frame(width: 240, height: 400)
                    }
                    
                })
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

struct DetailView: View {
    private var viewModel: ListViewModel = ListViewModel()
    var body: some View {
        
        VStack{
            
            Text(viewModel.name)
            
            Text(viewModel.atk)
            
            Text(viewModel.def)
        }
    }
}





#Preview {
    ListView()
}
