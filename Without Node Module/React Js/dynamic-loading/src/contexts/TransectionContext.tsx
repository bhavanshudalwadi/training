import { createContext, useContext, useState } from "react";
import { PaymentContextType, Payment } from "../@types/todo";
import { getPaymentsByPage } from "../TransactionAPI";

const transactionContext = createContext<PaymentContextType | null>(null);

export const TransactionState: React.FC<{children: React.ReactNode}> = ({ children }) => {
    const [pageNo, setPageNo] = useState<number>(1)
    const [hasMore, setHasMore] = useState<boolean>(true)
    const [payments, setPayments] = useState<Payment[]>([]);

    const fetchPayments = () => {
        getPaymentsByPage(pageNo)
            .then((res) => {
                if(res.data.length > 0) {
                    setPayments(payments.concat(res.data));
                }else {
                    setHasMore(false)
                }
            })
            .catch((error) => { 
                console.log(error);
            });
        setPageNo(pageNo+1)
    }

    return (
        <transactionContext.Provider
            value={{
                hasMore,
                payments,
                fetchPayments
            }}
        >
            { children }
        </transactionContext.Provider>
    );
}

export const useTransactionContext = (): PaymentContextType => {
    return useContext(transactionContext) as PaymentContextType
}