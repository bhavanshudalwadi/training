const Cart = () => {
  return (
    <div className="card rounded-3" style={{width: 200}}>
        <div className="row">
            <div className="col-6">Cart Items</div>
            <div className="col-6">2 Item(s)</div>
        </div>
        <div className="row border-bottom">
            <div className="col-9">Kissan Fresh Tomato Ketchup 1.1 kg</div>
            <div className="col-3">₹98.00 x 1</div>
        </div>
        <div className="row">
            <div className="col-8"><b>Total amount to be paid</b></div>
            <div className="col-4"><b>₹98.00</b></div>
        </div>
        <button className="btn btn-primary rounded-3">Proceed to Cart</button>
    </div>
  )
}

export default Cart
