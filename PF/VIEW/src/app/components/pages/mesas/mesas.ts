import { Component, OnInit, inject, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { SidebarNavComponent } from '../../organisms/sidebar-nav/sidebar-nav';
import { TablesManagerComponent } from '../../organisms/tables-manager/tables-manager';
import { MesaService } from '../../../auth/services/mesa.service';

@Component({
  selector: 'app-mesas',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    SidebarNavComponent,
    TablesManagerComponent
  ],
  templateUrl: './mesas.html',
  styleUrls: ['./mesas.css']
})
export class MesasPage implements OnInit {
  private mesaService = inject(MesaService);
  private fb = inject(FormBuilder);
  private cdr = inject(ChangeDetectorRef);

  mesas: any[] = [];
  isModalOpen = false;
  mesaForm: FormGroup;

  constructor() {
    this.mesaForm = this.fb.group({
      numeroMesa: ['', [Validators.required, Validators.min(1)]],
      capacidad: ['', [Validators.required, Validators.min(1)]],
      estado: ['LIBRE']
    });
  }

  ngOnInit() {
    this.cargarMesas();
  }

  cargarMesas() {
    console.log('Solicitando mesas al servidor...');
    this.mesaService.listarMesas().subscribe({
      next: (data: any) => {
        this.mesas = Array.isArray(data) ? data : (data ? [data] : []);
        console.log('Mesas finales en la vista:', this.mesas);
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error('Error al cargar mesas:', err);
      }
    });
  }

  abrirModal() {
    this.isModalOpen = true;
  }

  cerrarModal() {
    this.isModalOpen = false;
    this.mesaForm.reset({ estado: 'LIBRE' });
  }

  guardarMesa() {
    if (this.mesaForm.valid) {
      this.mesaService.crearMesa(this.mesaForm.value).subscribe({
        next: () => {
          this.cargarMesas();
          this.cerrarModal();
        },
        error: (err) => {
          console.error('Error al guardar mesa:', err);
          alert('Hubo un error al guardar la mesa');
        }
      });
    }
  }
}