//
//  ListViewModel.swift
//  iosApp
//
//  Created by Camila Juliao on 24/8/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

class ListViewModel: ObservableObject{
    
    @State var isImageActive = false
    @State var name = ""
    @State var atk = ""
    @State var def = ""
    
    
    @Published var pokemonInfo = [Pokemons]()
    
    init() {
        
        let url = URL(string: "https://db.ygoprodeck.com/api/v7/cardinfo.php")!
        
        var request = URLRequest(url: url)
        
        request.httpMethod = "GET"
        
        URLSession.shared.dataTask(with: request) { data, response, error in
            
            do{
                if let jsonData = data{
                    print("tamano del Json: \(jsonData)")
                    
                    let decodeData = try
                    JSONDecoder().decode(PokemonInfo.self, from: jsonData)
                    
                    DispatchQueue.main.async {
                        self.pokemonInfo.append(contentsOf: decodeData.data)
                    }
                    
                }
                
                
            }catch{
                print("Error: \(error)")
            }
            
        }.resume()

    }
    
}
