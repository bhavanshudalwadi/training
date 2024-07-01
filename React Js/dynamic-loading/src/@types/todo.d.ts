// @types.todo.ts
export interface Transaction {
    id: number,
    amount: number,
    from: string,
    ref_no: string,
    time: string
}

export interface Payment {
    date: string,
    total_collection: number,
    total_transactions: number,
    transactions: Transaction[]
}

export type PaymentContextType = {
    payments: Payment[];
    hasMore: boolean;
    fetchPayments: () => void;
}

export interface AlertInterface {
    type: string,
    msg: string
}

export interface DialogInterface {
    open: boolean,
    title: string,
    description: string,
    id: number,
    delete: boolean
}

export type GlobalContextType = {
    loading: boolean,
    setLoading: (boolean) => void,
    alert: AlertInterface,
    setAlert: (AlertInterface) => void,
    dialog: DialogInterface,
    setDialog: (DialogInterface) => void,
}

export interface Movie {
    Poster_Link: string,
    Series_Title: string,
    Released_Year: number,
    Certificate: string,
    Runtime: string,
    Genre: string,
    IMDB_Rating: number,
    Overview: string,
    Meta_score: number,
    Director: string,
    Star1: string,
    Star2: string,
    Star3: string,
    Star4: string,
    No_of_Votes: number,
    Gross: string
}

export type MovieContextType = {
    movies: Movie[];
    hasMore: boolean;
    fetchMovies: () => void;
}