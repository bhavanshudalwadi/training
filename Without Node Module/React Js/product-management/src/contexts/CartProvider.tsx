import { createContext, useContext, useReducer } from "react";
import { CartContextType } from "../@types/globalTypes";
import { CartReducer, initialItems } from "../reducers/CartReducer";

const cartContext = createContext<CartContextType | null>(null)

const CartProvider: React.FC<{children: React.ReactNode}> = ({ children }) => {
    // Creating cart reducer
    const [cartItems, dispatch] = useReducer(CartReducer, initialItems);

    return (
        <cartContext.Provider value={{cartItems, dispatch}}>
            { children }
        </cartContext.Provider>
    )
}

// Creating own cart context hook for easy use
const useCartContext = (): CartContextType  => {
    const context = useContext(cartContext) as CartContextType
    // Validating that cartContext is using within CartProvider
    if(!context) {
        console.log("cartContext only can be used within CartProvider")
    }
    return context
}

export { cartContext, CartProvider, useCartContext }