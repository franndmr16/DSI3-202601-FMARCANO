import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarNavComponent } from '../../organisms/sidebar-nav/sidebar-nav';
import { ClientsGridComponent } from '../../organisms/clients-grid/clients-grid';
import { ClienteService } from '../../../auth/services/cliente.service';


@Component({
  selector: 'app-clientes',
  standalone: true,
  imports: [
    CommonModule, 
    SidebarNavComponent, 
    ClientsGridComponent
  ],
  templateUrl: './clientes.html',
  styleUrls: ['./clientes.css']
})
export class ClientesPage implements OnInit {
  private clienteService = inject(ClienteService);
  clientes: any[] = []; 

  ngOnInit() {
    this.cargarClientes();
  }

  cargarClientes() {
    this.clienteService.listarClientes().subscribe({
      next: (data: any[]) => {
        this.clientes = data;
      },
      error: (err) => console.error('Error al cargar clientes:', err)
    });
  }
}