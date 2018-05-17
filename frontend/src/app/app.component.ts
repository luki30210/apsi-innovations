import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `<app-navbar></app-navbar>
            <div class="app-container">
                <router-outlet></router-outlet>
            </div>`
})
export class AppComponent {
}
