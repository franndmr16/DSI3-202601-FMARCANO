import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-stats-grid',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard-stats.html',
  styleUrls: ['./dashboard-stats.css']
})
//informacion quemada no me dio tiempo a terminar esta parte
export class DashboardStatsComponent { 
  stats = [
    { label: 'Mesas Ocupadas', value: '24' },
    { label: 'Ventas del Día', value: '$12.4k' },
    { label: 'Pedidos Activos', value: '5' },
    { label: 'Entregas hoy', value: '12' }
  ];
}