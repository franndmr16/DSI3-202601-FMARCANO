import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientsGrid } from './clients-grid';

describe('ClientsGrid', () => {
  let component: ClientsGrid;
  let fixture: ComponentFixture<ClientsGrid>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClientsGrid],
    }).compileComponents();

    fixture = TestBed.createComponent(ClientsGrid);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
