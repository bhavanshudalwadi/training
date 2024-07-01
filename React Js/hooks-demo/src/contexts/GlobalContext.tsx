import { createContext, useContext, useState } from "react";
import { GlobalContextType } from "../@types/todo";

const globalContext = createContext<GlobalContextType | null>(null);

export const GlobalProvider: React.FC<{children: React.ReactNode}> = ({ children }) => {
    const [themeColor, setThemeColor] = useState<string>("secondary-subtle")

    return (
        <globalContext.Provider value={{themeColor, setThemeColor}}>
            { children }
        </globalContext.Provider>
    )
}

export const useGlobalContext = (): GlobalContextType => {
    return useContext(globalContext) as GlobalContextType;
}