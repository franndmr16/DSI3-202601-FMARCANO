import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-sidebar-nav',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './sidebar-nav.html',
  styleUrls: ['./sidebar-nav.css']
})
export class SidebarNavComponent {
  menuItems = ['Dashboard', 'Productos', 'Mesas', 'Clientes', 'Pedidos'];
}