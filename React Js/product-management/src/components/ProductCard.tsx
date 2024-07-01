import { useCartContext } from '../contexts/CartProvider'
import { useGlobalContext } from '../contexts/GlobalProvider';
import './ProductCard.css'

const ProductCard = ({ id, title, description, thumbnail, price, discountPercentage, qty }: any) => {

    const { dispatch } = useCartContext()
    const { setCartOpen } = useGlobalContext();

    // Showing cart tooltip for 3 seconds
    const DisplayCart = () => {
        setCartOpen(true)
        setTimeout(() => {
            setCartOpen(false)
        }, 3000)
    }

    // Adding item to cart
    const addToCart = () => {
        dispatch({ type: "ADD", item: {id: 0, productId: id, qty: 1} })
        DisplayCart()
    }

    // Incrementing cart item quantity
    const incrementQty = () => {
        dispatch({ type: "INC", productId: id })
        DisplayCart()
    }

    // Decrementing cart item quantity
    const decrementQty = () => {
        dispatch({ type: "DEC", productId: id })
        DisplayCart()
    }

    return (
        <div className="card rounded-4 product">
            <div className='img-container'>
                <img src={thumbnail} className="card-img-top rounded-4"/>
            </div>
            <button className="btn position-absolute top-0 end-0 rounded-circle">
                <i className="bi bi-heart"></i>
            </button>
            <div className="card-body">
                <h5 className='description'>{title}</h5>
                <p className='description'>{description}</p>
                <h3>₹{price}.00</h3>
                <span className='d-inline-block'>
                    <span><s>₹{(price + (price * discountPercentage)/100).toFixed(2)}</s></span>
                    <span className="badge bg-success-subtle text-success-emphasis ms-2">{discountPercentage}% Off</span>
                </span>
                <div className='d-flex justify-content-end'>
                    {/* Showing Add to cart if qty is undefined */}
                    {qty === undefined ?
                        <button className='btn btn-primary w-100 mt-3' onClick={addToCart}>Add To Cart</button>
                        :<div className='d-flex mt-3'>
                            <button className='btn btn-primary' onClick={decrementQty}><i className="bi bi-dash-lg"></i></button>
                            <span className="badge bg-primary-subtle text-primary-emphasis mx-2 fs-5">{qty}</span>
                            <button className='btn btn-primary' onClick={incrementQty}><i className="bi bi-plus-lg"></i></button>
                        </div>
                    }
                </div>
            </div>
        </div>
    )
}

export default ProductCard
