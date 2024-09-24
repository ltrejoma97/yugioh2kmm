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
    private let testRealHelper = TestRealmHelper()
        
    @Published private(set) var blueEyesDragonsCards: CardDTOResponse = CardDTOResponse(data:[])
    @Published private(set) var writePaddintong: Void = ()
    @Published private(set) var readPaddintong: String = ""

        func getBlueEyesDragons() async{
            do{
                let getBlueEyesDragonsCardsHelper = try await getBlueEyesDragonCardsUseCaseHelper.callUseCase()
                self.blueEyesDragonsCards =  getBlueEyesDragonsCardsHelper
                print(blueEyesDragonsCards)
            }catch{
                print(error.localizedDescription)
            }
        }
        
        func writeTestRealmHlelper() async{
            do{
                let writeTestRealmHelper: Void = try await testRealHelper.writePaddingtong()
                self.writePaddintong = writeTestRealmHelper
            }catch{
                print(error.localizedDescription)
            }
        }
        
        func readTestRealmHlelper() async{
            do{
                let readTestRealmHelper: String = try await testRealHelper.readPaddingtong()
                self.readPaddintong = readTestRealmHelper
                print(readPaddintong)
            }catch{
                print(error.localizedDescription)
            }
        }
        
        func updateUiObject(yugiohCardsUiObject: YugiohCardsUiObject){
            uiObject = yugiohCardsUiObject
        }
    }
}
