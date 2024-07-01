import { useEffect } from "react";
import { useTransactionContext } from "../contexts/TransectionContext";
import InfiniteScroll from "react-infinite-scroll-component";
import Loader from "../components/Loader";
import PaymentCard from "../components/PaymentCard";

const Home = () => {
  const { payments, fetchPayments, hasMore } = useTransactionContext();

  useEffect(() => {
    fetchPayments();
  }, []);

  return (
    <div className="container" style={{marginTop: 90}}>
      <div className="row d-flex justify-content-center">
        <div className="col-md-6 align-items-center">
          <InfiniteScroll
            style={{overflowX: 'hidden'}}
            className="d-flex flex-column align-items-center"
            dataLength={payments.length}
            next={fetchPayments}
            hasMore={hasMore}
            loader={<Loader />}
            endMessage={<h2>Yay! You have seen it all</h2>}
          >
            <div>
              {payments != undefined && payments.length > 0 && payments.map((payment, index) => (
                <PaymentCard key={index} {...payment} />
              ))}
            </div>
          </InfiniteScroll>
        </div>
      </div>
    </div>
  )
}

export default Home
