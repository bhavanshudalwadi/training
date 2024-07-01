import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [],
  template: `
    <div class="header">
      Header
    </div>
  `,
  styles: `
    .header {
      background-color: #5246ff;
      color: white;
    }
  `
})
export class HeaderComponent {

}
