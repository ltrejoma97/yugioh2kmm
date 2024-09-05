//
//  PostViewModel.swift
//  iosApp
//
//  Created by Camila Juliao on 5/9/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import Shared

extension PostScreen{
    
    @MainActor class PostViewModel: ObservableObject{
        private let getPostUseCase = GetBlueEyesDragonCardsUseCase()
    }
}
