import { useDispatch } from "react-redux"
import { addTodo } from '../features/todo/todoSlice'
import { useState } from "react"

const AddTodo = () => {
    const [input, setInput] = useState<string>("")
    const dispatch = useDispatch()

    const addTodoHandler = (e: React.FormEvent<HTMLButtonElement>) => {
        e.preventDefault()
        if(input.trim() != "") {
            dispatch(addTodo({id: Math.floor(Math.random() * 999), text: input}))
            setInput("")
        }else {
            alert("Enter todo text")
        }
    }

    return (
        <div>
            <div className="mb-3">
                <label htmlFor="todoText" className="form-label">Add Todo</label>
                <div className="row">
                    <div className="col-10 pe-0">
                        <input type="text" className="form-control" id="todoText" value={input} onChange={(e) => setInput(e.target.value)} placeholder="e.g. Buy a milk" />
                    </div>
                    <div className="col-2">
                        <button className="btn bg-primary-subtle" onClick={(e) => addTodoHandler(e)}>Add</button>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default AddTodo
