// @types.todo.ts
export type GlobalContextType = {
    themeColor: string,
    setThemeColor: (string) => void,
}

export interface ProductType {
    id: number,
    qty: number,
    title: string
}