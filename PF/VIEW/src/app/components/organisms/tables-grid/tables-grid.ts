import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-tables-grid',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './tables-grid.html',
  styleUrls: ['./tables-grid.css']
})
export class TablesGridComponent {
  tables = [1, 2, 3, 4, 5, 6];
}