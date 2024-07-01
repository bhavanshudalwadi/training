import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { TodoType, TodoState } from "../../@types/todo";

const initialState: TodoState = {
    todos: [],
}

export const todoSlice = createSlice({
    name: 'todo',
    initialState,
    reducers: {
        addTodo: (state: TodoState, action: PayloadAction<TodoType>) => {
            const todo = {
                id: action.payload.id,
                text: action.payload.text
            }
            state.todos.push(todo)
        },
        removeTodo: (state: TodoState, action: PayloadAction<number>) => {
            state.todos = state.todos.filter(t => t.id !== action.payload)
        }
    }
})

export const { addTodo, removeTodo } = todoSlice.actions
export default todoSlice.reducer