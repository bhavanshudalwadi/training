// .ts => typescript

let val: number = 60
val = 89

// let name: string = 'bhavanshu'
let fname = 'bhvanshu dalwadi.' 
let isSomething: boolean

console.log(val, fname)

let isValueEmpty: null
let isValueExist: undefined

// tsc --init => tsconfig.json
// tsc --watch => hot reload and update index.js
// node --watch dist/index.js

// arrays
let names: string[] = ['bhavanshu', 'henil', 'deep']
let nums: number[] = [56, 78, 90]

names.push('something')
nums.push(20)

console.log(names, nums)

let something = ['hello', 89, false]
something.push('hay')
something.push(7592)
something.push(false)
console.log(something)

// object litrals
let newObj: {id: number, fname: string, age: number} = {
    id: 1,
    fname: "hello",
    age: 89
}

newObj.id = 78
newObj.fname = 'henil'

console.log(newObj)

// type interface with object literals
let person = {
    name: 'jainil',
    age: 21
}

console.log(person)

// Array of Objects
let arrOfObj: Object[] = [
    {
        id: 1,
        name: 'hello',
        age: 21,
        email: 'hello123@gmail.com',
        isLogedIn: true
    }
]

console.log(arrOfObj)

// function
function addNums(a: number, b: number): number{
    return a + b;
}

const subNums = (a: number, b: number): number => {
    return a - b;
}

console.log(addNums(1 ,8), subNums(1, 8))

// any type
let anyVal: any

anyVal = 78
anyVal = 'bhavanshu'
anyVal = false

let anyArr: any[] = ['hello', true, 80, null, undefined]
anyArr.push({ id: 78 })

console.log(anyArr)

function anyFun(val: any): any {
    return val + val
}

console.log(anyFun(5), anyFun('hello '))

// tupples
let tupple: [string, number, boolean] = ['bhavanshu', 56, false]
console.log(tupple)

const getCoordinates = (): [number, number] => {
    return [67.78756376, 78.2464233]
}

const [lat, long] = getCoordinates();

console.log(lat, long)

let user: [name: string, age: number]
user = ['henil', 22]

console.log(user)
console.log(user[0])

let obj: { name: string, age: number }
obj = { name: 'deep', age: 90 }
console.log(obj);
console.log(obj.name);

// interfaces
interface Post {
    title: string,
    body: string,
    tags: string[],
    created_at: Date,
    auther: string
}

const newPost: Post = {
    title: 'my New Post',
    body: 'a lots of bla bla bla...',
    tags: ['gaming', 'tech'],
    created_at: new Date(),
    auther: 'someone'
}

function createPost(post: Post): void {
    console.log(`Created post '${post.title}' by ${post.auther}`)
}

createPost(newPost);

let posts: Post[] = [];
posts.push(newPost);
console.log(posts);

// type alias
type RGB = [number, number, number];

function getRandom(): number {
    return Math.floor(Math.random() * 255)
}

const getRandomColor = (): RGB => {
    return [getRandom(), getRandom(), getRandom()]
}

console.log(getRandomColor());

// union types
let someId: number | string

someId = 78;
someId = '90';

let email: string | null
email = 'nullvalue@gmail.com'
email = null

type ID = number | string
let anotherId: ID

anotherId = 'd76fv4s5a'
anotherId = 67

// type guards
function swapIdType(id: ID) {
    return typeof id === 'string'?parseInt(id):id.toString()
}

console.log(swapIdType('55'));
console.log(swapIdType(55));