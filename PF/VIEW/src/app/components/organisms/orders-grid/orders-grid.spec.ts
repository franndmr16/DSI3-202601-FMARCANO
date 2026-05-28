import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdersGrid } from './orders-grid';

describe('OrdersGrid', () => {
  let component: OrdersGrid;
  let fixture: ComponentFixture<OrdersGrid>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OrdersGrid],
    }).compileComponents();

    fixture = TestBed.createComponent(OrdersGrid);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
