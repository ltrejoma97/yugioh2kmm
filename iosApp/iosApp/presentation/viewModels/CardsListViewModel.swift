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
    @Published private(set) var blueEyesDragonsCardsArray: [YugiohCard] = []
    @Published private(set) var blueDragosCardsFlow: [String] = []


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
        
        func getFlowBlueEyesDragons(){
            // en la linea 32 se genera una llamada al helper del caso de uso que va a retornar un "Flow" que puede ser manejado en swift esta encapsulado en la clase FlowWrapper
            let flowWrapper = getBlueEyesDragonCardsUseCaseHelper.testFlow()
            //la clase Flow Wrapper tiene una funcion que permite observar el flow (llamada al .watch) para que vayan llegando los valores
            flowWrapper.watch { value in
                if let array =  value as? String{
                    self.blueDragosCardsFlow.append(array)
                }else{
                    print("No se pudo convertir NSArray")
                }
                print("Received value: \(String(describing: value))")
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
        
        func convertNSArrayInArray(){
            if let array =  blueEyesDragonsCards as? [YugiohCard]{
                array.forEach{ element in
                    blueEyesDragonsCardsArray.append(element)
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
