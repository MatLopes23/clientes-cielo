import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CriarClienteComponent } from './criar-cliente.component';

describe('CriarClienteComponent', () => {
  let component: CriarClienteComponent;
  let fixture: ComponentFixture<CriarClienteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CriarClienteComponent]
    });
    fixture = TestBed.createComponent(CriarClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
