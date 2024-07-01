import { useSelector } from "react-redux"
import Todo from "./Todo"
import { TodoState } from "../@types/todo"

const Todos = () => {
    const todos = useSelector((state: TodoState) => state.todos)

    return (
        <>
            {todos.map(todo => <Todo key={todo.id} {...todo} />)}
        </>
    )
}

export default Todos
