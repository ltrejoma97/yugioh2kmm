//
//  AppDelegate.swift
//  iosApp
//
//  Created by luisT on 2/10/24.
//  Copyright © 2024 orgName. All rights reserved.
//


import SwiftUI
import FirebaseCore
import FirebaseFirestore
import FirebaseAuth




class AppDelegate: UIResponder, UIApplicationDelegate {
    var window: UIWindow?

    override init() {
        super.init()
        FirebaseApp.configure()
    }
}
