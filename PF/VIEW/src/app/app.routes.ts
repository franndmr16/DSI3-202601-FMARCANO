import { Routes } from '@angular/router';
import { DashboardPage } from './components/pages/dashboard/dashboard';
import { ProductosPage } from './components/pages/productos/productos';
import { MesasPage } from './components/pages/mesas/mesas';
import { ClientesPage } from './components/pages/clientes/clientes';
import { PedidosPage } from './components/pages/pedidos/pedidos';
import { RegisterComponent } from './auth/pages/registro/registro';
import { LoginComponent } from './auth/pages/login/login';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'registro', component: RegisterComponent },
  { path: 'dashboard', component: DashboardPage },
  { path: 'productos', component: ProductosPage },
  { path: 'mesas', component: MesasPage },
  { path: 'clientes', component: ClientesPage },
  { path: 'pedidos', component: PedidosPage },
  { path: '', redirectTo: '/login', pathMatch: 'full' }
];