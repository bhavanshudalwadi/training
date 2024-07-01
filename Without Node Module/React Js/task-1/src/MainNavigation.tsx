
import { Route, Routes } from "react-router-dom"
import Home from "./pages/Home"
import About from "./pages/About"
import ContactUs from "./pages/ContactUs"

const MainNavigation = () => {
  return (
    <main className='container'>
        <Routes>
            <Route index element={<Home />} />
            <Route path="/about" element={<About />} />
            <Route path="/contact-us" element={<ContactUs />} />
        </Routes>
    </main>
  )
}

export default MainNavigation
