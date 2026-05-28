import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-clients-grid',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './clients-grid.html',
  styleUrls: ['./clients-grid.css']
})
export class ClientsGridComponent {
  @Input() clients: any[] = [];

  constructor() {}

  editClient(client: any) {
    console.log('Editando a:', client.nombre);
  }

  deleteClient(client: any) {
    console.log('Eliminando a:', client.nombre);
    this.clients = this.clients.filter(c => c !== client);
  }
}