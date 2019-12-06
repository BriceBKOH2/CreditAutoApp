import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CalcSheetComponent } from './calc-sheet.component';

describe('CalcSheetComponent', () => {
  let component: CalcSheetComponent;
  let fixture: ComponentFixture<CalcSheetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CalcSheetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CalcSheetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
