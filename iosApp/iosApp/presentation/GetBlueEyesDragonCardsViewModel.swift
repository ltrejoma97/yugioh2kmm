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
        
//        @Published private(set) var blueEyesDragons = CardDTOResponse(data: <#T##[CardDto]#>)
        
        func getBlueEyesDragons() async{ 
            do{
                print("Hola1")
                let getBlueEyesDragons1 = try await getBlueEyesDragonCardsUseCase.callUseCase()
                print("Hola2")
//                self.$blueEyesDragons.append(getBlueEyesDragons1)
                print("\(getBlueEyesDragons1) estoy aqui")
                print("Hola3")
            }catch{
                print("es un error")
            }
        }
        
    }
}
