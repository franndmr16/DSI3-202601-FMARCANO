import { Component, OnInit, inject, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { SidebarNavComponent } from '../../organisms/sidebar-nav/sidebar-nav';
import { ProductGridComponent } from '../../organisms/product-grid/product-grid';
import { ProductoService } from '../../../auth/services/producto.service';

@Component({
  selector: 'app-productos',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, SidebarNavComponent, ProductGridComponent],
  templateUrl: './productos.html',
  styleUrls: ['./productos.css']
})
export class ProductosPage implements OnInit {
  private productoService = inject(ProductoService);
  private fb = inject(FormBuilder);
  private cdr = inject(ChangeDetectorRef);

  productos: any[] = [];
  isModalOpen = false;
  productoForm: FormGroup;

  constructor() {
    this.productoForm = this.fb.group({
      nombre:      ['', [Validators.required, Validators.minLength(2)]],
      descripcion: [''],
      precio:      ['', [Validators.required, Validators.min(0)]],
      categoria:   ['', Validators.required],
      disponible:  [true]
    });
  }

  ngOnInit() {
    this.cargarProductos();
  }

  cargarProductos() {
    this.productoService.listarProductos().subscribe({
      next: (data) => {
        this.productos = Array.isArray(data) ? data : (data ? [data] : []);
        this.cdr.detectChanges();
      },
      error: (err) => console.error('Error al cargar productos:', err)
    });
  }

  abrirModal()  { this.isModalOpen = true; }
  cerrarModal() { this.isModalOpen = false; this.productoForm.reset({ disponible: true }); }

  guardarProducto() {
    if (this.productoForm.invalid) { this.productoForm.markAllAsTouched(); return; }
    this.productoService.crearProducto(this.productoForm.value).subscribe({
      next: () => {
        this.cerrarModal();
        setTimeout(() => {
          this.cargarProductos();
        }, 300);
      },
      error: (err) => { 
        console.error('Error al guardar producto:', err); 
        alert('Error al guardar el producto'); 
      }
    });
  }
}