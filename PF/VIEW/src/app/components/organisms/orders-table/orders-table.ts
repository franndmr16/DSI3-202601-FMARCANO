import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-orders-table',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './orders-table.html',
  styleUrls: ['./orders-table.css']
})
export class OrdersTableComponent {
  orders = [
    { id: '#034', mesa: 'Mesa 1', total: '$45.00', status: 'En preparación' },
    { id: '#035', mesa: 'Mesa 3', total: '$12.50', status: 'Listo' },
    { id: '#036', mesa: 'Mesa 5', total: '$88.20', status: 'En preparación' }
  ];
}