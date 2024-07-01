import { Component, inject } from '@angular/core';
import { ProductCardComponent } from '../product-card/product-card.component';
import { CommonModule } from '@angular/common';
import {MatButtonModule} from '@angular/material/button';
import { SearchComponent } from '../search/search.component';
import { ProductService } from '../../services/product.service';
import { Product, ProductsAPI } from '../../@types/product';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [ProductCardComponent, CommonModule, SearchComponent, MatButtonModule, RouterLink],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {
  products:Product[] = []
  filteredProducts:Product[] = []

  // Injecting Product Service
  productService = inject(ProductService)
  // Injecting Router
  router = inject(Router)

  // Initializing Component Elements
  ngOnInit() {
    this.productService.getProducts().subscribe((result: ProductsAPI) => {
      this.products = result.products
      this.filteredProducts = result.products
    })
  }

  // Filtering products on search
  searchProducts(searchInput: string) {
    console.log(searchInput)
    if(searchInput.trim() != "") {
      this.products = this.filteredProducts.filter(p => 
                        p.title.toLowerCase().includes(searchInput.toLowerCase()) ||
                        p.description.toLowerCase().includes(searchInput.toLowerCase())
                      )
    }else {
      this.products = this.filteredProducts
    }
  }

  // view product details
  onViewProduct(event: any) {
    console.log("viewProduct", event)
    this.router.navigateByUrl(`/product/${event}`)
  }
}
