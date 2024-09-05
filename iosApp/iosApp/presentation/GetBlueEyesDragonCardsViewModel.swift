//
//  PostViewModel.swift
//  iosApp
//
//  Created by Camila Juliao on 5/9/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import Shared

extension GetBlueEyesDragonCardsScreen{
    
    @MainActor class GetBlueEyesDragonCardsViewModel: ObservableObject{
        private let getBlueEyesDragonCardsUseCase: () = GetBlueEyesDragonCardsUseCase()
        
        @Published private(set) var blueEyesDragons: [YugiohCardsInfo] = []
        
        func getBlueEyesDragons() async{
            do{
//                let getBlueEyesDragons: () = try await getBlueEyesDragonCardsUseCase.invoke()
                
            }catch{
                
            }
        }
        
    }
}
