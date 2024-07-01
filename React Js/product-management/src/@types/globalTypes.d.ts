export type ProductType = {
    id?: number,
    title: string,
    description: string,
    price: number,
    discountPercentage: number,
    rating: number,
    stock: number,
    brand: string,
    category: string,
    thumbnail: string,
    images?: string[]
}

export type CartItemType = {
    id: number,
    productId: number,
    qty: number
}

export type CartContextType = {
    cartItems: CartItemType[],
    dispatch: React.Dispatch<any>
}

export type GlobalContextType = {
    isCartOpen: boolean,
    setCartOpen: (isCartOpen: boolean) => void
}

export type ProductContextType = {
    products: ProductType[],
    setProducts: (products: ProductType[]) => void,
    getProductList: () => void
}