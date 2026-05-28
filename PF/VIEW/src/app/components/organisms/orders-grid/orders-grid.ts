import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PedidoService } from '../../../auth/services/pedido.service';

@Component({
  selector: 'app-orders-grid',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './orders-grid.html',
  styleUrls: ['./orders-grid.css']
})
export class OrdersGridComponent implements OnInit {
  private pedidoService = inject(PedidoService);
  orders: any[] = []; 

  ngOnInit() {
    this.cargarPedidos();
  }

  cargarPedidos() {
    this.pedidoService.listarPedidos().subscribe({
      next: (data: any[]) => { 
        this.orders = data; 
      },
      error: (err: any) => { 
        console.error('Error al cargar pedidos:', err); 
      }
    });
  }

  avanzarPedido(id: number) {
    this.pedidoService.avanzarEstado(id).subscribe({
      next: () => this.cargarPedidos(),
      error: (err) => console.error('Error al avanzar estado:', err)
    });
  }

  eliminar(id: number) {
    if(confirm('¿Estás seguro de eliminar este pedido?')) {
      this.pedidoService.eliminarPedido(id).subscribe({
        next: () => this.cargarPedidos(),
        error: (err) => console.error('Error al eliminar:', err)
      });
    }
  }
}