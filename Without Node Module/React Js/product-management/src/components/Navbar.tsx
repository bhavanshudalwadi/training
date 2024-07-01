import { safePolygon, useFloating, useInteractions, useHover, useDismiss } from '@floating-ui/react';
import { useGlobalContext } from '../contexts/GlobalProvider';
import { useMemo } from 'react';
import { useCartContext } from '../contexts/CartProvider';
import { useProductContext } from '../contexts/ProductProvider';

const Navbar = () => {
    const { isCartOpen, setCartOpen } = useGlobalContext()
    const { cartItems } = useCartContext()
    const { products } = useProductContext()

    // For floating tooltip
    const {refs, floatingStyles, context} = useFloating({
        open: isCartOpen,
        onOpenChange: setCartOpen,
    });

    // To dismiss hover
    const dismiss = useDismiss(context);

    // Showing tooltip on hover
    const hover = useHover(context, {
        handleClose: safePolygon({
          requireIntent: false,
        }),
    });

    const { getReferenceProps, getFloatingProps } = useInteractions([
        hover,
        dismiss
    ]);

    // Adding product name and product price to cart items
    const filteredItems = useMemo(() => {
        return cartItems.map(c => ({ ...c, 
                                    productName: products.find(p => p.id === c.productId)?.title,
                                    productPrice: products.find(p => p.id === c.productId)?.price
                                }));
    }, [cartItems, products]);

    // calculating total cart amount
    const cartTotal = useMemo(() => {
        return filteredItems.reduce((count, item) => count + ((item.productPrice != undefined?item.productPrice:0) * item.qty), 0)
    }, [filteredItems])

    return (
        <nav className="navbar navbar-expand-lg bg-primary-subtle mb-4">
            <div className="container">
                <a className="navbar-brand" href="#">Product Management</a>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="nav-item">
                            <a className="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                    </ul>
                    <form className="d-flex" role="search">
                        <button
                            type="button"
                            className="btn btn-primary"
                            ref={refs.setReference}
                            {...getReferenceProps()}
                        >
                            <i className="bi bi-cart3"></i>
                        </button>
                        {isCartOpen && (
                            <div className="card rounded-3 z-3" ref={refs.setFloating} {...getFloatingProps()} style={{...floatingStyles, width: 350}}>
                                <div className="card-body">
                                    <div className="row">
                                        <div className="col-6"><b>Cart Items</b></div>
                                        <div className="col-6 text-end"><b>{filteredItems.length} Item(s)</b></div>
                                    </div>
                                    {/* Mapping all filtered items */}
                                    {filteredItems && filteredItems.map(item => 
                                        <>
                                            <div className="d-flex justify-content-between">
                                                <div className="">{item.productName}</div>
                                                <div className="text-end">₹{item.productPrice}.00 x {item.qty}</div>
                                            </div>
                                            <hr className='my-1'/>
                                        </>
                                    )}
                                    <div className="row mt-2">
                                        <div className="col-8"><b>Total amount to be paid</b></div>
                                        <div className="col-4 text-end"><b>₹{cartTotal}.00</b></div>
                                    </div>
                                    <button className="btn btn-primary rounded-3 mt-3 w-100">Proceed to Cart</button>
                                </div>
                            </div>
                        )}
                    </form>
                </div>
            </div>
        </nav>
    )
}

export default Navbar
