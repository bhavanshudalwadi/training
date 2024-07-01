import { useCallback, useEffect, useReducer, useRef, useState } from "react"
import { GlobalProvider } from "./contexts/GlobalContext"
import Navbar from "./components/Navbar"
import Footer from "./components/Footer"
import { CartReducer, initialProducts } from "./reducers/CartReducer"

function App() {
  const [state, setState] = useState<string>("")
  const nameInput = useRef<HTMLInputElement>(null);
  const [products, dispatch] = useReducer(CartReducer, initialProducts);
  const [products2, dispatch2] = useReducer(CartReducer, initialProducts);
  const [title, setTitle] = useState<string>("Navbar")

  const onChangeTitle = useCallback((t: string) => {
    setTitle(t)
  }, [title]) 

  useEffect(() => {
    setState("Bhavanshu")
    nameInput.current?.focus()
  }, [])

  return (
    <>
      <GlobalProvider>
        <Navbar title={title} onChangeTitle={onChangeTitle}/>
        <div className="container mt-3">
          <div className="mb-3">
            <label htmlFor="name" className="form-label">Name</label>
            <input type="email" className="form-control" ref={nameInput} id="name" onChange={(e) => setState(e.target.value)} placeholder="Enter your name" />
          </div>
          {state != "" && <h2>Hello!, {state}</h2>}
          <hr />
          <h2>Cart Products</h2>
          {products.map(product => 
            <div className="card d-inline-block" key={product.id}>
              <div className="card-body">
                <h4>{product.title}</h4>
                <div className="d-flex justify-content-between">
                  <button className="btn bg-secondary-subtle px-3" onClick={() => dispatch({ type: "DEC", id: product.id, qty: 1 })}>-</button>
                  <span className="badge bg-secondary-subtle text-black mx-2 p-3">{product.qty}</span>
                  <button className="btn bg-secondary-subtle px-3" onClick={() => dispatch({ type: "INC", id: product.id, qty: 1 })}>+</button>
                </div>
              </div>
            </div>
          )}
          {products2.map(product => 
            <div className="card d-inline-block" key={product.id}>
              <div className="card-body">
                <h4>{product.title}</h4>
                <div className="d-flex justify-content-between">
                  <button className="btn bg-secondary-subtle px-3" onClick={() => dispatch2({ type: "DEC", id: product.id, qty: 1 })}>-</button>
                  <span className="badge bg-secondary-subtle text-black mx-2 p-3">{product.qty}</span>
                  <button className="btn bg-secondary-subtle px-3" onClick={() => dispatch2({ type: "INC", id: product.id, qty: 1 })}>+</button>
                </div>
              </div>
            </div>
          )}
        </div>
        <Footer />
      </GlobalProvider>
    </>
  )
}

export default App
