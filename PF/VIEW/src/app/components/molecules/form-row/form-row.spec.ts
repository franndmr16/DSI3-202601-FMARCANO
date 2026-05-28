import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormRow } from './form-row';

describe('FormRow', () => {
  let component: FormRow;
  let fixture: ComponentFixture<FormRow>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormRow],
    }).compileComponents();

    fixture = TestBed.createComponent(FormRow);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
