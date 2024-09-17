//
//  HelloWorldScreen.swift
//  iosApp
//
//  Created by Camila Juliao on 10/9/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct HelloWorldScreen: View {
    @State var isActive: Bool = false
    var body: some View {
       
        NavigationView{
            NavigationLink(destination: WorldScreen(), isActive: $isActive){
                Text(/*@START_MENU_TOKEN@*/"Hello, World!"/*@END_MENU_TOKEN@*/)
                Button(action: {isActive = true}, label: {EmptyView()})
            }
        }
    }
}


//#Preview {
//    HelloWorldScreen(isActive: <#Binding<Bool>#>)
//}
