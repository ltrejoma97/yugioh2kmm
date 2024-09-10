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
        private let getBlueEyesDragonCardsUseCase = GetBlueEyesDragonCardsUseCaseHelper.init()
        @Published private(set) var blueEyesDragons: String = ""
        
        func getBlueEyesDragons() async{
            do{
                let getBlueEyesDragons1 = try await getBlueEyesDragonCardsUseCase.callUseCase()
                self.blueEyesDragons = self.blueEyesDragons + blueEyesDragons
                print("\(getBlueEyesDragons1) estoy aqui")
                print("Hola")
            }catch{
                print(error.localizedDescription)
            }
        }
        
    }
}
