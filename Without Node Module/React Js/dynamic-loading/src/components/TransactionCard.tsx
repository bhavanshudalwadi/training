import { Transaction } from "../@types/todo"

const TransactionCard = ({ time, ref_no, amount, from } : Transaction) => {
  return (
    <div className="col-12 mb-2">
      <div className="card transaction-card">
        <div className="row">
          <div className="col-9">
            <div className="row">
              <div className="col-4 pe-0">
                <p>{ time }</p>
              </div>
              <div className="col-8 pe-0">
                <p>{ ref_no }</p>
              </div>
              <div className="col-12 pe-0">
                <p>{ from }</p>
              </div>
            </div>
          </div>
          <div className="col-3 d-flex align-items-center">
            <h4>₹ { amount }</h4>
          </div>
        </div>
      </div>
    </div>
  )
}

export default TransactionCard
