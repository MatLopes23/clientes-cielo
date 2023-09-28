import { ClienteService } from './../shared/services/cliente.service';
import { Component } from '@angular/core';
import { IClienteResponse } from '../shared/models/cliente.model';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-listar-cliente',
  templateUrl: './listar-cliente.component.html',
  styleUrls: ['./listar-cliente.component.scss'],
})
export class ListarClienteComponent {
  displayedColumns: string[] = ['id', 'cpf', 'nome', 'email'];
  clientes: MatTableDataSource<IClienteResponse> =
    new MatTableDataSource<IClienteResponse>();

  constructor(private clienteService: ClienteService) {}

  ngOnInit() {
    this.loadClientes();
  }

  loadClientes() {
    this.clienteService.getClientes().subscribe((data: IClienteResponse[]) => {
      console.log(data);
      this.clientes = new MatTableDataSource(data);
    });
  }
}
