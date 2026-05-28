import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface DetallePedidoDTO {
  idProducto: number;
  cantidad: number;
}

export interface PedidoRequestDTO {
  idMesa: number;
  idCliente: number;
  idUsuario: number;
  estado: string;
  detalles: DetallePedidoDTO[];
}

@Injectable({
  providedIn: 'root'
})
export class PedidoService {
  private apiUrl = 'http://localhost:9000/api/productos';

  constructor(private http: HttpClient) { }
  listarPedidos(estado?: string): Observable<any[]> {
    const url = estado ? `${this.apiUrl}?estado=${estado}` : this.apiUrl;
    return this.http.get<any[]>(url);
  }

  obtenerPorId(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  crearPedido(pedido: PedidoRequestDTO): Observable<any> {
    return this.http.post<any>(this.apiUrl, pedido);
  }

  avanzarEstado(id: number): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}/estado`, {});
  }

  eliminarPedido(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}