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
                
                // en la linea 32 se genera una llamada al helper del caso de uso que va a retornar un "Flow" que puede ser manejado en swift esta encapsulado en la clase FlowWrapper
                let flowWrapper = getBlueEyesDragonCardsUseCaseHelper.testFlow()
                //la clase Flow Wrapper tiene una funcion que permite observar el flow (llamada al .watch) para que vayan llegando los valores
                flowWrapper.watch { value in
                    print("Received value: \(value)")
                }
                
                let getBlueEyesDragonsCardsHelper = try await getBlueEyesDragonCardsUseCaseHelper.callUseCase()
                self.blueEyesDragonsCards =  getBlueEyesDragonsCardsHelper
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
