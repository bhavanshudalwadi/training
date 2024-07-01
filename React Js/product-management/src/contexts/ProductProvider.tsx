import { createContext, useContext, useState } from "react";
import { ProductContextType, ProductType } from "../@types/globalTypes";
import { getProducts } from "../ProductsAPI";

const productContext = createContext<ProductContextType | null>(null)

const ProductProvider: React.FC<{children: React.ReactNode}> = ({ children }) => {
    // Creating products state
    const [products, setProducts] = useState<ProductType[]>([]) 

    // Getting product list from api
    const getProductList = () => {
        getProducts()
            .then((res) => {
                if(res.data.products) {
                    // setting products to state
                    setProducts(res.data.products)
                }
            })
            .catch((error) => { 
                // logging error if occur
                console.log(error);
            });
    }

    return (
        <productContext.Provider value={{products, setProducts, getProductList}}>
            { children }
        </productContext.Provider>
    )
}

// Creating own product context hook for easy use
const useProductContext = (): ProductContextType  => {
    const context = useContext(productContext) as ProductContextType
    // Validating that productContext is using within ProductProvider
    if(!context) {
        console.log("productContext only can be used within ProductProvider")
    }
    return context
}

export { productContext, ProductProvider, useProductContext }