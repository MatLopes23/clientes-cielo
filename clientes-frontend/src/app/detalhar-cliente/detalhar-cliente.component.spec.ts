import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalharClienteComponent } from './detalhar-cliente.component';

describe('DetalharClienteComponent', () => {
  let component: DetalharClienteComponent;
  let fixture: ComponentFixture<DetalharClienteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DetalharClienteComponent]
    });
    fixture = TestBed.createComponent(DetalharClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
