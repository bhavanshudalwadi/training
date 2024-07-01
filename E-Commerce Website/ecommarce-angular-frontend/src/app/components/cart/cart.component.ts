import { Component, DoCheck, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CartService } from '../../services/cart.service';
import { OrderService } from '../../services/order.service';
import { AuthService } from '../../services/auth.service';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule,
    RouterLink
  ],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.scss'
})
export class CartComponent implements OnInit, DoCheck {
  cartItems: any[] = []

  address: string = ""
  payment_mode: string = ""

  totalItems: number = 0
  totalAmount: number = 0

  constructor(private cartService: CartService, private orderService: OrderService, private authService: AuthService) {}

  ngOnInit() {
    this.getCarts()
  }

  ngDoCheck() {
    if(this.cartItems && this.cartItems.length > 0) {
      this.totalItems = this.cartItems.reduce((t: number, c: any) => t + c.quantity , 0)
      this.totalAmount = this.cartItems.reduce((t: number, c: any) => t + (c.product.price * c.quantity) , 0)
    }
  }

  getCarts = () => {
    this.authService.loading = true
    const promise = this.cartService.getCart()
    if(promise) {
      promise.subscribe({
        next: (response: any) => {
          if(Array.isArray(response)) {
            this.cartItems = response
          }else {
            alert('Failed to get cart')
            console.log(response)
          }
        },
        error: (e: any) => {
          alert("Failed to get cart");
          console.error(e);
        },
        complete: () => {this.authService.loading = false}
      })
    }
  }

  handleQtyUpdate = (product_id: string, qty: number) => {
    if(product_id != '' && qty >= 0) {
      this.authService.loading = true
      const promise = this.cartService.updateCartQty(product_id, qty)
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
          error: (e: any) => {
            alert('Add to cart failed');
            console.error(e);
          },
          complete: () => {this.authService.loading = false}
        })
      }
    }
  }

  handlePlaceOrder = () => {
    if(this.cartItems && Array.isArray(this.cartItems) && this.cartItems.length > 0 && this.address.trim() != '' && this.payment_mode.trim() != '') {
      let carts = [...this.cartItems]
      this.authService.loading = true
      const promise = this.orderService.placeOrder(carts.map((c: any) => c._id), this.address.trim(), this.payment_mode.trim(), `₹ ${this.totalAmount} Cash`)
      if(promise) {
        promise.subscribe({
          next: (response: any) => {
            if(response._id) {
              alert('Order Placed Successful')
              this.getCarts()
            }else {
              alert('Failed to get cart')
              console.log(response)
            }
          },
          error: (e: any) => {
            alert("Failed to get cart");
            console.error(e);
          },
          complete: () => {this.authService.loading = false}
        })
      }
    }else {
      alert('Order details are invalid')
    }
  }
}
