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
        
//    @Published private(set) var blueEyesDragonsCards: CardDTOResponse = CardDTOResponse(data:[], error: <#String#>)
    @Published var blueEyesDragonsCards: NSArray = NSArray(array: [])
    @Published private(set) var writePaddintong: Void = ()
    @Published private(set) var readPaddintong: String = ""
        

        func getBlueEyesDragons() async -> NSArray  {     
            do{
                let getBlueEyesDragonsCardsHelper = try await getBlueEyesDragonCardsUseCaseHelper.callUseCase()
                blueEyesDragonsCards = getBlueEyesDragonsCardsHelper.data ?? NSArray(array: [])
                print(blueEyesDragonsCards)
            }catch{
                print(error.localizedDescription)
            }
            return blueEyesDragonsCards
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
        
        func convertNSArrayInList() async{
            if let array = await getBlueEyesDragons() as? [YugiohCard]{
                array.forEach{ element in
                    print(element)
                }
            }else{
                print("No se pudo convertir NSArray")
            }
        }
        
        func updateUiObject(yugiohCardsUiObject: YugiohCardsUiObject){
            uiObject = yugiohCardsUiObject
        }
    }
}
