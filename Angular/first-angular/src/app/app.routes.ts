import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { AddProductComponent } from './components/add-product/add-product.component';

export const routes: Routes = [
    {
        path: "",
        component: HomeComponent
    },
    {
        path: "products",
        component: HomeComponent
    },
    {
        path: "product/:id",
        component: ProductDetailsComponent
    },
    {
        path: "add-product",
        component: AddProductComponent
    }
];
