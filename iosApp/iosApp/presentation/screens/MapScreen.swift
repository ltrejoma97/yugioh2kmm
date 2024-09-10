//
//  MapView.swift
//
//  Created by Camila Juliao on 24/8/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import MapKit

struct MapScreen: View {
    
    @ObservedObject var viewModel = MapViewModel()
    
    var body: some View {
        VStack {
 
            if #available(iOS 17.0, *) {
                Map(){
                    Marker("pin1", coordinate: viewModel.pin1)
                    
                    Marker("pin2", coordinate: viewModel.pin2)
                    
                    Marker("pin3", coordinate: viewModel.pin3)
                }
            } else {
                // Fallback on earlier versions
            }
        }.frame(height: 350)
    }
}

#Preview {
 MapScreen()
   
}
