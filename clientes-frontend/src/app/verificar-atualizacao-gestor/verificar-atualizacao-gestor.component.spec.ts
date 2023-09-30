import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerificarAtualizacaoGestorComponent } from './verificar-atualizacao-gestor.component';

describe('VerificarAtualizacaoGestorComponent', () => {
  let component: VerificarAtualizacaoGestorComponent;
  let fixture: ComponentFixture<VerificarAtualizacaoGestorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VerificarAtualizacaoGestorComponent]
    });
    fixture = TestBed.createComponent(VerificarAtualizacaoGestorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
