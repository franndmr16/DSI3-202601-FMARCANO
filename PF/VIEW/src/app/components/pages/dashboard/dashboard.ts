import { Component } from '@angular/core';
import { SidebarNavComponent } from '../../organisms/sidebar-nav/sidebar-nav';
import { OrdersTableComponent } from '../../organisms/orders-table/orders-table';
import { TablesGridComponent } from '../../organisms/tables-grid/tables-grid';
import { DashboardStatsComponent } from '../../organisms/dashboard-stats/dashboard-stats';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    SidebarNavComponent, 
    DashboardStatsComponent, 
    OrdersTableComponent, 
    TablesGridComponent
  ],
  templateUrl: './dashboard.html',
  styleUrls: ['./dashboard.css']
})
export class DashboardPage { }