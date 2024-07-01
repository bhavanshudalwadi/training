import { Component, OnInit } from '@angular/core';
import { environment } from '../../../environments/environment';
import { OrderService } from '../../services/order.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-orders',
  standalone: true,
  imports: [],
  templateUrl: './orders.component.html',
  styleUrl: './orders.component.scss'
})
export class OrdersComponent implements OnInit {
  public environment = environment
  orders: any[] = []

  constructor(private orderService: OrderService, private authService: AuthService) {}

  ngOnInit() {
    this.authService.loading = true
    const promise = this.orderService.getOrders()
    if(promise) {
      promise.subscribe({
        next: (response: any) => {
          if(Array.isArray(response)) {
            this.orders = response
          }else {
            alert('Failed to get orders')
            console.log(response)
          }
        },
        error: (e) => {
          alert("Failed to get orders");
          console.error(e);
        },
        complete: () => {this.authService.loading = false}
      })
    }
  }

  changeDateFormate = (date: string) => {
    let d = new Date(date);
    return d.getDate() + '-' + (d.getMonth() + 1) + '-' + d.getFullYear();
  }
}
