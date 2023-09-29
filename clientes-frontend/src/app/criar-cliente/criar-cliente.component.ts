import { ClienteService } from './../shared/services/cliente.service';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TipoClienteEnum } from '../shared/models/cliente.model';

@Component({
  selector: 'app-criar-cliente',
  templateUrl: './criar-cliente.component.html',
  styleUrls: ['./criar-cliente.component.scss'],
})
export class CriarClienteComponent {
  clienteForm: FormGroup = new FormGroup({});
  isPessoaFisica = true;

  constructor(
    private fb: FormBuilder,
    private clienteService: ClienteService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.clienteForm = this.fb.group({
      tipoCliente: [],
      cnpj: [null, [Validators.required, Validators.pattern(/^\d{14}$/)]],
      razaoSocial: [null, [Validators.required, Validators.maxLength(50)]],
      mcc: [null, Validators.maxLength(4)],
      cpfResponsavel: [
        null,
        [Validators.required, Validators.pattern(/^\d{11}$/)],
      ],
      nomeResponsavel: [null, [Validators.required, Validators.maxLength(50)]],
      emailContato: [
        null,
        [
          Validators.required,
          Validators.pattern(
            /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/
          ),
        ],
      ],
    });
  }

  togglePessoa() {
    this.isPessoaFisica = !this.isPessoaFisica;
  }

  criarCliente() {
    const clienteData = this.clienteForm.value;
    if (this.isPessoaFisica)
      clienteData.tipoCliente = TipoClienteEnum.PESSOA_FISICA;
    else clienteData.tipoCliente = TipoClienteEnum.PESSOA_JURIDICA;

    this.clienteService.postCliente(clienteData).subscribe(
      (response) => {
        this.router.navigate(['/list']);
      },
      (error) => {
        console.error('Erro ao criar o cliente', error);
      }
    );
  }
}
