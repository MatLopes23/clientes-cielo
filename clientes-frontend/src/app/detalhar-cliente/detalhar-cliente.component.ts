import { Component, Input, OnInit } from '@angular/core';
import { ClienteService } from '../shared/services/cliente.service';
import { IClienteResponse } from '../shared/models/cliente.model';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-detalhar-cliente',
  templateUrl: './detalhar-cliente.component.html',
  styleUrls: ['./detalhar-cliente.component.scss'],
})
export class DetalharClienteComponent implements OnInit {
  clienteId: number = 0;
  cliente: IClienteResponse = {
    id: '',
    cpf: '',
    nome: '',
    tipoCliente: '',
    email: '',
    mcc: '',
    cnpj: '',
    razaoSocial: '',
  };
  isPessoaFisica: boolean = true;

  constructor(
    private clienteService: ClienteService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.clienteId = params['id'];
      this.carregarDetalhesDoCliente();
    });
  }

  carregarDetalhesDoCliente() {
    this.clienteService.getClientePorId(this.clienteId).subscribe(
      (cliente) => {
        this.cliente = cliente;
        this.isPessoaFisica = !cliente.cnpj;
      },
      (error) => {
        console.error('Erro ao recuperar o cliente', error);
      }
    );
  }
}
