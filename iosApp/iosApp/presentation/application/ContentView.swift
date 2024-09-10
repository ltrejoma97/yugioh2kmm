import SwiftUI
import SwiftData

struct ContentView: View {
  

    var body: some View {
        NavigationView{
            HomeScreen()
            
        }.navigationBarHidden(true)
    }

   
}

#Preview {
    ContentView()
}
