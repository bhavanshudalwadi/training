import { BrowserRouter } from "react-router-dom"
import Footer from "./components/Footer"
import Header from "./components/Header"
import MainNavigation from "./MainNavigation"
import { useState } from "react"

function App() {
  const [title, setTitle] = useState<string>("Vite")
  const [theme, setTheme] = useState<string>("bg-warning-subtle")

  return (
    <>
      <BrowserRouter>
        <Header title={title} setTitle={setTitle} theme={theme} setTheme={setTheme} />
        <MainNavigation />
        <Footer title={title} theme={theme}/>
      </BrowserRouter>
    </>
  )
}

export default App
