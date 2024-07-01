import { ProductType } from "../@types/todo";

export const initialProducts: ProductType[] = [
    {
      id: 1,
      qty: 1,
      title: "Item 1"
    }
];

export const CartReducer = (state: ProductType[], action: any) => {
    switch (action.type) {
        case "INC":
            return state.map((product) => {
                if (product.id === action.id) {
                    return { ...product, qty: product.qty + action.qty };
                } else {
                    return product;
                }
            });
        case "DEC":
            return state.map((product) => {
                if (product.id === action.id) {
                    if(product.qty !== 1) {
                        return { ...product, qty: product.qty - action.qty };
                    }else {
                        return product;
                    }
                } else {
                    return product;
                }
            });
        default:
            return state;
    }
};