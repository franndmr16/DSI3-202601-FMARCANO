import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-tables-manager',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './tables-manager.html',
  styleUrls: ['./tables-manager.css']
})
export class TablesManagerComponent {
  @Input() tables: any[] = [];
}