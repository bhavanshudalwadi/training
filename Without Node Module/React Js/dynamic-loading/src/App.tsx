import { BrowserRouter } from 'react-router-dom';
import MainNavigation from './MainNavigation';
import Navbar from './components/Navbar';
import { GlobalState } from './contexts/GlobalContext';
import { TransactionState } from './contexts/TransectionContext';
import { MovieState } from './contexts/MovieContext';

function App() {

  return (
    <>
      <BrowserRouter basename="/transactions">
        <GlobalState>
          <TransactionState>
            <MovieState>

              <Navbar />
              <MainNavigation />
              {/* <AlertMessage />u
              <AlertDialog /> */}

            </MovieState>
          </TransactionState>
        </GlobalState>
      </BrowserRouter>    
    </>
  )
}

export default App
