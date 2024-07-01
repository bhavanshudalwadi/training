import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

export const authGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);
  const userToken = localStorage.getItem('ecomm-angular-token');

  if(!userToken) {
    return true;
  }
  router.navigateByUrl('/')
  return false;
};
