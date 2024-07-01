import { Component, inject } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { Product } from '../../@types/product';
import { FormsModule } from '@angular/forms';
import { ProductService } from '../../services/product.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { AlertDialogComponent } from '../alert-dialog/alert-dialog.component';

@Component({
  selector: 'app-add-product',
  standalone: true,
  imports: [MatButtonModule, MatInputModule, FormsModule],
  templateUrl: './add-product.component.html',
  styleUrl: './add-product.component.scss'
})
export class AddProductComponent {
  constructor(public dialog: MatDialog) {}

  product: Product = {
    title: '',
    description: '',
    price: 0,
    discountPercentage: 0,
    rating: 0,
    stock: 0,
    brand: '',
    category: '',
    thumbnail: ''
  }

  productService = inject(ProductService)
  router = inject(Router)

  addProduct() {
    this.productService.addNewProduct(this.product).subscribe(result => {
      this.openDialog()
      this.router.navigateByUrl("/") 
    })
  }

  openDialog(): void {
    this.dialog.open(AlertDialogComponent, {
      width: '250px',
      data: {
        title: 'Successful',
        message: 'Product Added Successful'
      },
    });
  }
}
