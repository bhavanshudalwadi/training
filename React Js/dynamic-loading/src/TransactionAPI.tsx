import axios from "axios";

export const apiURL = "https://bhavanshu.000webhostapp.com/payments-api";
// export const apiURL = "http://localhost/payments-api";

const axiosInstance = axios.create({
    baseURL: apiURL,
    timeout: 300000
})

export function getPaymentsByPage(page: number) {
    return axiosInstance.get(`/getPaymentsByPage.php?page=${page}`);
}