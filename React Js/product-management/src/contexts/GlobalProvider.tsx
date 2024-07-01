import { createContext, useContext, useState } from "react";
import { GlobalContextType } from "../@types/globalTypes";

const globalContext = createContext<GlobalContextType | null>(null)

const GlobalProvider: React.FC<{children: React.ReactNode}> = ({ children }) => {
    // creating global state for cart tooltip
    const [isCartOpen, setCartOpen] = useState<boolean>(false);

    return (
        <globalContext.Provider value={{isCartOpen, setCartOpen}}>
            { children }
        </globalContext.Provider>
    )
}

// Creating own global context hook for easy use
const useGlobalContext = (): GlobalContextType  => {
    const context = useContext(globalContext) as GlobalContextType
    // Validating that globalContext is using within GlobalProvider
    if(!context) {
        console.log("globalContext only can be used within GlobalProvider")
    }
    return context
}

export { globalContext, GlobalProvider, useGlobalContext }