import { Routes } from '@angular/router';
import { CoffeeComponent } from './screens/coffee/coffee';

export const routes: Routes = [
  { path: 'coffee', component: CoffeeComponent },
  { path: '', redirectTo: '/coffee', pathMatch: 'full' }
];