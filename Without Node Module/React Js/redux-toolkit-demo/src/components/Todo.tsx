import { useDispatch } from "react-redux"
import { TodoType } from "../@types/todo"
import { removeTodo } from "../features/todo/todoSlice"

const Todo = ({id, text}: TodoType) => {
    const dispatch = useDispatch()
    
    return (
        <div className="alert bg-primary-subtle alert-dismissible fade show mb-2" role="alert">
            <h5 className="m-0">{text}</h5>
            <button type="button" className="btn-close" onClick={() => dispatch(removeTodo(id))}></button>
        </div>
    )
}

export default Todo
