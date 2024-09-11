//
//  HomeView.swift
//  iosApp
//
//  Created by Camila Juliao on 24/8/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI



struct HomeScreen: View {
    
    @ObservedObject var viewModel = HomeViewModel()
    
    var body: some View {
        
        TabView(selection: viewModel.$tabSeleccionado){
        
            CardsListScreen()
                .font(.system(size: 30, weight: .bold, design: .rounded))
                .tabItem {
                    Image(systemName: "list.bullet")
                    
                    Text("Card List")
     
                }.tag(0)
        
            MapScreen()
                .font(.system(size: 30, weight: .bold, design: .rounded))
                .tabItem {
                    Image(systemName: "map")
                    Text("Map")
                    
                }.tag(1)
           
            HelloWorldScreen()
                .font(.system(size: 30, weight: .bold, design: .rounded))
                .tabItem {
                    Image(systemName: "network")
                    Text("Hello world")
                    
                }.tag(2)
        }
    }
}

#Preview {
    HomeScreen()
}

