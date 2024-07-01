import { createContext, useContext, useState } from "react";
import { AlertInterface, DialogInterface, GlobalContextType } from "../@types/todo";

const globalContext = createContext<GlobalContextType | null>(null);

export const GlobalState: React.FC<{children: React.ReactNode}> = ({ children }) => {

    const [loading, setLoading] = useState<boolean>(false);
    const [dialog, setDialog] = useState<DialogInterface>({
        open: false,
        title: "",
        description: "",
        id: 0,
        delete: false
    });
    const [alert, setAlert] = useState<AlertInterface>({
        type: "info",
        msg: "",
    });

    return (
        <globalContext.Provider
            value={{
                loading,
                setLoading,
                alert,
                setAlert,
                dialog,
                setDialog,
            }}
        >
            { children }
        </globalContext.Provider>
    );
}

export const useGlobalContext = (): GlobalContextType => {
    return useContext(globalContext) as GlobalContextType
}