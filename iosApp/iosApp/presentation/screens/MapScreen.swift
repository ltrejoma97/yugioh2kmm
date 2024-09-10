//
//  MapView.swift
//  iosApp
//
//  Created by Camila Juliao on 24/8/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import MapKit

struct MapScreen: View {
    
    let pin1 = CLLocationCoordinate2D(latitude: 9.142891, longitude: -66.38551)
    
    let pin2 = CLLocationCoordinate2D(latitude: 9.152891, longitude: -66.38551)
    let pin3 = CLLocationCoordinate2D(latitude: 9.162891, longitude: -66.38551)
    
    var body: some View {
        VStack {
//            Map(){
//                Marker("pin1", coordinate: pin1)
//                
//                Marker("pin2", coordinate: pin2)
//                
//                Marker("pin3", coordinate: pin3)
//            }
        }.frame(height: 350)
    }
}

#Preview {
 MapScreen()
   
}
