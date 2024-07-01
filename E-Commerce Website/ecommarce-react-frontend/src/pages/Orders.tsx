import { useEffect } from 'react'
import { useOrderContext } from '../contexts/OrderProvider'
import { imageURL } from '../API'

const Orders = () => {
    const { orders, getOrders } = useOrderContext()

    useEffect(() => {
        getOrders()
    }, [])

    const changeDateFormate = (date: string) => {
        let d = new Date(date);
        return d.getDate() + '-' + (d.getMonth() + 1) + '-' + d.getFullYear();
    }

    return (
        <div className='row'>
            <div className="col-md-2"></div>
            {orders && Array.isArray(orders) && orders.length === 0
                ? <div className="col-md-8">
                    <div className="card">
                        <div className="card-body text-center">
                            <h4>Your have no orders :)</h4>
                        </div>
                    </div>
                </div>
                : <div className="col-md-8">
                    {orders && orders.map((order: any) =>
                        <div className="card mt-3">
                            <div className="card-body">
                                <div className="d-flex justify-content-between">
                                    <h5>Date: <span className='d-inline-block'>{changeDateFormate(order.date)}</span></h5>
                                    <h5 className='text-end'>Order Status: <span className="badge text-bg-primary">{order.status}</span></h5>
                                </div>
                                <div className="row">
                                    <div className="col-md-8">
                                        {order.products && Array.isArray(order.products) && order.products.map((c: any) =>
                                            <div className="card d-flex flex-row mt-3">
                                                <img src={`${imageURL}/${c.product.image}`} className="card-img-left" style={{ width: 100 }} alt="product-image" />
                                                <div className="card-body">
                                                    <h5 className="card-title product-name">{c.product.name}</h5>
                                                    <div className="d-flex justify-content-between">
                                                        <h4>₹ {c.product.price}</h4>
                                                        <h5>Qty: {c.quantity}</h5>
                                                    </div>
                                                </div>
                                            </div>
                                        )}
                                    </div>
                                    <div className="col-md-4">
                                        <h6 className='mt-3'>Delivery Address: </h6>
                                        <p>{order.address}</p>
                                        <h6>Payment Mode: </h6>
                                        <p><span className="badge text-bg-primary">{order.payment.mode}</span></p>
                                        <h6>Payment Details: </h6>
                                        <p>{order.payment.details}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    )}
                </div>}
            <div className="col-md-2"></div>
        </div>
    )
}

export default Orders