import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TypeBadgeComponent } from '../../atoms/type-badge/type-badge';

@Component({
  selector: 'app-pokemon-card',
  standalone: true,
  imports: [CommonModule, TypeBadgeComponent],
  templateUrl: './pokemon-card.html',
  styleUrls: ['./pokemon-card.css']
})
export class PokemonCardComponent {
  @Input() id: number = 0;
  @Input() name: string = '';
  @Input() image: string = '';
  @Input() types: any[] = [];

  @Output() pokemonSelected = new EventEmitter<number>();

  onCardClick(): void {
    this.pokemonSelected.emit(this.id);
  }
}