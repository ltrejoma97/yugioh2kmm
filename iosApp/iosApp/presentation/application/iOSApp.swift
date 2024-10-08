import SwiftUI
import Shared


@main
struct iOSApp: App {
    
    init(){
        HelperKt.doInitKoin()
    }
    @UIApplicationDelegateAdaptor(AppDelegate.self) var delegate

    var body: some Scene {
        WindowGroup {
           HomeScreen()
        }
    }
}



