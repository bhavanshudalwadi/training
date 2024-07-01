import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-loader',
  standalone: true,
  imports: [],
  template: `
    <div class="loader-container" [style]="authService.loading?'display: flex; position: absolute':'display: none'">
      <img src="/assets/loading.gif" style="width: 150px; height: 150px" />
    </div>
  `,
  styles: `
    .loader-container {
      background-color: #000;
      opacity: 0.6;
      display: flex;
      position: absolute;
      top: 0;
      left: 0;
      right: 0;
      bottom: 0;
      align-items: center;
      justify-content: center;
    }
  `
})
export class LoaderComponent {
  constructor(public authService: AuthService) {}
}
