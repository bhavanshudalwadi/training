import axios from "axios";

// export const apiURL = "https://bhavanshu.000webhostapp.com/payments-api";
export const apiURL = "http://localhost/movies-api";

const axiosInstance = axios.create({
    baseURL: apiURL,
    timeout: 300000
})

export function getMoviesByPage(page: number) {
    return axiosInstance.get(`/getMoviesByPage.php?page=${page}&per_page=12`);
    // return axiosInstance.get(`/getMoviesByPage.php?page=${page}&per_page=1000`);
}