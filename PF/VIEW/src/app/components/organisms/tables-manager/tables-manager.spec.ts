import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablesManager } from './tables-manager';

describe('TablesManager', () => {
  let component: TablesManager;
  let fixture: ComponentFixture<TablesManager>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TablesManager],
    }).compileComponents();

    fixture = TestBed.createComponent(TablesManager);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
