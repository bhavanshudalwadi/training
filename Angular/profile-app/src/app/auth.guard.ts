import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

export const authGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);
  const userToken = localStorage.getItem('profile_app_user');

  if(userToken != null) {
    return true;
  }
  router.navigateByUrl('/login')
  return false;
};
