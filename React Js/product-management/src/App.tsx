import Navbar from "./components/Navbar"
import { CartProvider } from "./contexts/CartProvider"
import { GlobalProvider } from "./contexts/GlobalProvider"
import { ProductProvider } from "./contexts/ProductProvider"
import Home from "./pages/Home"

function App() {
  return (
    <>
      <GlobalProvider>
        <CartProvider>
          <ProductProvider>
            <Navbar />
            <main className="container">
              <Home />
            </main>
          </ProductProvider>
        </CartProvider>
      </GlobalProvider>
    </>
  )
}

export default App
