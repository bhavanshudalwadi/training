import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Product, ProductsAPI } from '../@types/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  baseURL = "https://dummyjson.com"
  httpClient = inject(HttpClient)

  constructor() { }

  getProducts() {
    return this.httpClient.get<ProductsAPI>(`${this.baseURL}/products`)
  }

  getProductById(id: number) {
    return this.httpClient.get<Product>(`${this.baseURL}/products/${id}`)
  }

  addNewProduct(product: Product) {
    return this.httpClient.post<Product>(`${this.baseURL}/products/add`, product)
  }
}
