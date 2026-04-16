import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CoffeeComponent } from '../../../screens/coffee/coffee'; 

@Component({
  selector: 'app-coffee-page',
  standalone: true,
  imports: [CommonModule, CoffeeComponent],
  template: `
    <div class="p-coffee-page">
      <app-coffee></app-coffee> 
    </div>
  `,
  styles: [`
    .p-coffee-page {
      min-height: 100vh;
      background-color: #731B02;; 
    }
  `]
})
export class CoffeePage {}