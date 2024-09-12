//
//  PostViewModel.swift
//  iosApp
//
//  Created by Camila Juliao on 5/9/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import Shared
import SwiftUI

extension CardsListScreen{
    
    @MainActor class CardsListViewModel: ObservableObject{
        
    @State var uiObject: YugiohCardsUiObject =  YugiohCardsUiObject()
    @State var isImageActive: Bool = false
        
    private let getBlueEyesDragonCardsUseCaseHelper = GetBlueEyesDragonCardsUseCaseHelper.init()
        
    @Published private(set) var blueEyesDragonsCards: CardDTOResponse = CardDTOResponse(data:[])

        func getBlueEyesDragons() async{
            do{
                let getBlueEyesDragonsCardsHelper = try await getBlueEyesDragonCardsUseCaseHelper.callUseCase()
                self.blueEyesDragonsCards =  getBlueEyesDragonsCardsHelper
            }catch{
                print(error.localizedDescription)
            }
        }
        
        func updateUiObject(yugiohCardsUiObject: YugiohCardsUiObject){
            uiObject = yugiohCardsUiObject
        }
    }
}
