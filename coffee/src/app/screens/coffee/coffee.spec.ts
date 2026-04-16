import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoffeeComponent } from './coffee';

describe('Coffee', () => {
  let component: CoffeeComponent;
  let fixture: ComponentFixture<CoffeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CoffeeComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(CoffeeComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
