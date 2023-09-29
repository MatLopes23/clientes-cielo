import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExcluirClienteDialogComponent } from './excluir-cliente-dialog.component';

describe('ExcluirClienteDialogComponent', () => {
  let component: ExcluirClienteDialogComponent;
  let fixture: ComponentFixture<ExcluirClienteDialogComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ExcluirClienteDialogComponent]
    });
    fixture = TestBed.createComponent(ExcluirClienteDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
