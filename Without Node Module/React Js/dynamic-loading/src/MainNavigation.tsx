import { Routes, Route } from "react-router-dom";
import Home from './pages/Home';
import Movies from "./pages/Movies";

const MainNavigation = () =>{
    return (
        <Routes>
            <Route path="/" element={<Home />}/>
            <Route path="/movies" element={<Movies />}/>
        </Routes>
    )
}

export default MainNavigation;