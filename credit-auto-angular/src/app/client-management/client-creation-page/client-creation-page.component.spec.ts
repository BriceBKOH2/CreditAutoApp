import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientCreationPageComponent } from './client-creation-page.component';

describe('ClientCreationPageComponent', () => {
  let component: ClientCreationPageComponent;
  let fixture: ComponentFixture<ClientCreationPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientCreationPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientCreationPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
