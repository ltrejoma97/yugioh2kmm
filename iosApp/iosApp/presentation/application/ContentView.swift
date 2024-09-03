import SwiftUI
import SwiftData

struct ContentView: View {
  

    var body: some View {
        NavigationView{
            HomeView()
            
        }.navigationBarHidden(true)
    }

   
}

#Preview {
    ContentView()
}
