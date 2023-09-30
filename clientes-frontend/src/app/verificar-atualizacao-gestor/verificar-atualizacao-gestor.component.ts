import { Component } from '@angular/core';
import { IClienteResponse } from '../shared/models/cliente.model';
import { GestorService } from '../shared/services/gestor.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-verificar-atualizacao-gestor',
  templateUrl: './verificar-atualizacao-gestor.component.html',
  styleUrls: ['./verificar-atualizacao-gestor.component.scss'],
})
export class VerificarAtualizacaoGestorComponent {
  cliente?: IClienteResponse = {
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
    private gestorService: GestorService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.carregarUltimaAtualizacaoGestor();
  }

  carregarUltimaAtualizacaoGestor() {
    this.gestorService.getUltimaModificacaoCliete().subscribe(
      (cliente) => {
        this.cliente = cliente;
        this.isPessoaFisica = !cliente.cnpj;
      },
      (error) => {
        console.error('Erro ao recuperar o cliente do gestor', error);
        this.cliente = undefined;
      }
    );
  }
}
