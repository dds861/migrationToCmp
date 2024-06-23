//
//  iosAppApp.swift
//  iosApp
//
//  Created by Daniyar Nurgaliyev on 10/6/24.
//

import SwiftUI
import shared

@main
struct iosAppApp: App {

    init() {
            KoinInitializerKt.doInitKoin()
        }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
