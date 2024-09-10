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
        private let getBlueEyesDragonCardsUseCaseHelper = GetBlueEyesDragonCardsUseCaseHelper.init()
    @Published private(set) var blueEyesDragons: CardDTOResponse = CardDTOResponse(data: [])

        func getBlueEyesDragons() async{
            do{
                let getBlueEyesDragons1 = try await getBlueEyesDragonCardsUseCaseHelper.callUseCase()
                self.blueEyesDragons =  getBlueEyesDragons1
            }catch{
                print(error.localizedDescription)
            }
        }
    }
}
