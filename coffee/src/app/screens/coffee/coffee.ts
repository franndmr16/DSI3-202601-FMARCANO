import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HeaderComponent } from '../../components/organisms/header/header';
import { FooterComponent } from '../../components/organisms/footer/footer';

@Component({
  selector: 'app-coffee',
  standalone: true,
  imports: [RouterModule, HeaderComponent, FooterComponent],
  templateUrl: './coffee.html',
  styleUrl: './coffee.css'
})
export class CoffeeComponent {}