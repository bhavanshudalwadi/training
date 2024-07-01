import axios from "axios";

export const apiURL = "https://dummyjson.com/";

const axiosInstance = axios.create({
    baseURL: apiURL,
    timeout: 300000
})

// Fetching All Products
export function getProducts() {
    return axiosInstance.get(`/products`);
}