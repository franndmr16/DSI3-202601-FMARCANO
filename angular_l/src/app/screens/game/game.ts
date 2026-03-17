import { Component } from '@angular/core';
import { Header } from '../../components/header/header';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-game',
  imports: [
    Header,
    CommonModule,
    FormsModule
  ],
  templateUrl: './game.html',
  styleUrl: './game.css',
})
export class Game {
  elements: number = 0;
  options: number[] = []
  jugadores: string[] = ['BOB', 'ALICE', 'EMPATE']

  generateElements(event: number): void{
    console.log("El padre escuchó: ", event)
    this.elements = event;
    this.options = Array(event).fill('')
  }
}
