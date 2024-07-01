import { Component, DoCheck, OnInit } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { CartService } from '../../services/cart.service';
import { AuthService } from '../../services/auth.service';
import { ActivatedRoute, RouterLink } from '@angular/router';

@Component({
  selector: 'app-product-details',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './product-details.component.html',
  styleUrl: './product-details.component.scss'
})
export class ProductDetailsComponent implements OnInit, DoCheck {
  product_id: string = ""
  product: any = null
  cart: any[] = []

  constructor(private route: ActivatedRoute, private productService: ProductService, private cartService: CartService, private authService: AuthService) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.product_id = params['id'];
      this.getProduct()
    });
    this.getCarts()
  }

  ngDoCheck() {
    if(this.product && this.cart) {
      let carts = [...this.cart]
      this.product.qty = carts.find((c: any) => c.product._id === this.product._id) != undefined?carts.find((c: any) => c.product._id === this.product._id).quantity:0;
    }
  }

  getProduct = () => {
    this.authService.loading = true
    this.productService.getProductDetails(this.product_id).subscribe({
      next: (response: any) => {
        if(response._id) {
          this.product = response
        }else {
          alert('Failed to get product')
          console.log(response)
        }
      },
      error: (e) => {
        alert("Failed to get product");
        console.error(e);
      },
      complete: () => {this.authService.loading = false}
    })
  }

  getCarts = () => {
    const promise = this.cartService.getCart()
    if(promise) {
      promise.subscribe({
        next: (response: any) => {
          if(Array.isArray(response)) {
            this.cart = response
          }else {
            alert('Failed to get cart')
            console.log(response)
          }
        },
        error: (e) => {
          alert("Failed to get cart");
          console.error(e);
        },
        complete: () => {this.authService.loading = false}
      })
    }
  }

  handleAddToCart = () => {
    this.authService.loading = true
    if(this.product_id != '') {
      const promise = this.cartService.addToCart(this.product_id)
      if(promise) {
        promise.subscribe({
          next: (response: any) => {
            if(response._id) {
              alert('Item added to cart');
              this.getCarts()
            }
          },
          error: (e) => {
            alert('Add to cart failed');
            console.error(e);
          },
          complete: () => {this.authService.loading = false}
        })
      }
    }
  }

  handleQtyUpdate = (qty: number) => {
    this.authService.loading = true
    if(this.product_id != '' && qty >= 0) {
      const promise = this.cartService.updateCartQty(this.product_id, qty)
      if(promise) {
        promise.subscribe({
          next: (response: any) => {
            if(response._id) {
              this.getCarts()
            }else {
              console.log('Failed to update cart', response)
              if(response.error) {
                  alert(response.error);
              }
            }
          },
          error: (e) => {
            alert('Add to cart failed');
            console.error(e);
          },
          complete: () => {this.authService.loading = false}
        })
      }
    }
  }
}
