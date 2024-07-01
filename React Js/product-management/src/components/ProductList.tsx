import { useEffect, useMemo } from "react"
import ProductCard from "./ProductCard"
import { useCartContext } from "../contexts/CartProvider";
import { useProductContext } from "../contexts/ProductProvider";

const ProductList = () => {
  // Getting all cart items
  const { cartItems } = useCartContext()
  // Getting all products
  const { products, getProductList } = useProductContext()

  // Feting products from api on render
  useEffect(() => {
    getProductList()
  }, [])

  // Adding qty to product list if product is added to cart
  const filteredProducts = useMemo(() => {
    return products.map(p => ({ ...p, qty: cartItems.find(c => c.productId === p.id)?.qty }));
  }, [products, cartItems]);

  return (
    <>
        <h5>Top Deals You May Like</h5>
        <div className="row mt-3">
          {/* Showing all product list */}
          {filteredProducts && filteredProducts.map(product => 
            <div className="col-md-3 mt-3 pe-0" key={product.id}>
                <ProductCard {...product}/>
            </div>
          )}
        </div>
    </>
  )
}

export default ProductList
