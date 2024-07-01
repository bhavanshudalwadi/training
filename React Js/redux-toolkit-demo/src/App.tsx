import AddTodo from './components/AddTodo'
import Todos from './components/Todos'

function App() {
  return (
    <>
      <div className="container mt-5">
        <div className="row d-flex justify-content-center">
          <div className="col-md-6">
            <div className="card">
              <div className="card-body">
                <AddTodo />
                <Todos />
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  )
}

export default App
