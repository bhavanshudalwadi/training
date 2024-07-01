import { Payment } from "../@types/todo";
import './PaymentCard.css'
import TransactionCard from "./TransactionCard";

const PaymentCard = ({ date, total_collection, total_transactions, transactions }: Payment) => {

  return (
    <div className="card payment-card mb-3">
      <h2>{ date }</h2>
      <div className="row">
        <div className="col-6">Total Collection</div>
        <div className="col-6">Total Transactions</div>
        <div className="col-6"><h3>₹ { total_collection }</h3></div>
        <div className="col-6"><h3>{ total_transactions }</h3></div>
      </div>
      <div className="row">
        {transactions != undefined && transactions.length > 0 && transactions.map((transaction, index) => 
          <TransactionCard key={index} {...transaction} />
        )}
      </div>
    </div>
  )
}

export default PaymentCard
