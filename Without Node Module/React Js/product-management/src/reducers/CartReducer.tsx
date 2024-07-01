import { CartItemType } from "../@types/globalTypes";

const initialItems: CartItemType[] = [];

const CartReducer = (state: CartItemType[], action: any) => {
    switch (action.type) {
        // Add item to cart
        case "ADD":
            if(action.item != null) {
                return [...state, action.item]
            }else {
                return state
            }
        // Delete item from cart
        case "DEL":
            if(action.item != null) {
                return state.filter(item => item.id != action.id)
            }else {
                return state
            }
        // Increment quantity of cart item
        case "INC":
            return state.map((product) => {
                if (product.productId === action.productId) {
                    return { ...product, qty: product.qty + 1 };
                } else {
                    return product;
                }
            });
        // Decreasing quantity of cart item
        case "DEC":
            const updated = state.map((product) => {
                if (product.productId === action.productId) {
                    return { ...product, qty: product.qty - 1 };
                } else {
                    return product;
                }
            });
            return updated.filter(p => p.qty != 0)
        default:
            return state;
    }
};

export { initialItems, CartReducer }