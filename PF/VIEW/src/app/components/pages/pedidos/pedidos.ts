import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarNavComponent } from '../../organisms/sidebar-nav/sidebar-nav';
import { OrdersGridComponent } from '../../organisms/orders-grid/orders-grid';

@Component({
  selector: 'app-pedidos',
  standalone: true,
  imports: [CommonModule, SidebarNavComponent, OrdersGridComponent],
  templateUrl: './pedidos.html',
  styleUrls: ['./pedidos.css']
})
export class PedidosPage {}