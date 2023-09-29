import { ClienteService } from './../shared/services/cliente.service';
import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-excluir-cliente-dialog',
  templateUrl: './excluir-cliente-dialog.component.html',
  styleUrls: ['./excluir-cliente-dialog.component.scss'],
})
export class ExcluirClienteDialogComponent {
  displayedColumns: string[] = ['id', 'type', 'status', 'Message'];

  constructor(
    public dialogRef: MatDialogRef<ExcluirClienteDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private clienteService: ClienteService,
    private router: Router
  ) {}

  ngOnInit() {}

  excluirCliente() {
    this.clienteService.deleteCliente(this.data.id).subscribe(
      (response) => {
        window.location.reload();
      },
      (error) => {
        console.error('Erro ao excluir o cliente', error);
      }
    );
  }

  fecharDialog() {
    this.dialogRef.close();
  }
}
