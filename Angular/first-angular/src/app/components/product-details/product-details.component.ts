import { Component, Input, inject } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { Product } from '../../@types/product';
import { ProductService } from '../../services/product.service';
import { ActivatedRoute } from '@angular/router';
import {MatChipsModule} from '@angular/material/chips';

@Component({
  selector: 'app-product-details',
  standalone: true,
  imports: [MatCardModule, MatButtonModule, MatChipsModule],
  templateUrl: './product-details.component.html',
  styleUrl: './product-details.component.scss'
})
export class ProductDetailsComponent {
  @Input() product!: Product;

  // Injecting Product Service
  productService = inject(ProductService)
  activatedRoute = inject(ActivatedRoute)

  ngOnInit() {
    this.productService.getProductById(this.activatedRoute.snapshot.params["id"]).subscribe((result: Product) => {
      this.product = result
    })
  }
}
