import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-criar-cliente',
  templateUrl: './criar-cliente.component.html',
  styleUrls: ['./criar-cliente.component.scss'],
})
export class CriarClienteComponent {
  clienteForm: FormGroup = new FormGroup({});
  isPessoaFisica = true;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.clienteForm = this.fb.group({
      cnpj: ['', [Validators.required, Validators.pattern(/^\d{14}$/)]],
      razaoSocial: ['', [Validators.required, Validators.maxLength(50)]],
      mcc: ['', Validators.maxLength(4)],
      cpfContato: ['', [Validators.required, Validators.pattern(/^\d{11}$/)]],
      nomeContato: ['', [Validators.required, Validators.maxLength(50)]],
      emailContato: [
        '',
        [
          Validators.required,
          Validators.pattern(
            /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/
          ),
        ],
      ],
      cpf: ['', [Validators.required, Validators.pattern(/^\d{11}$/)]],
      nome: ['', [Validators.required, Validators.maxLength(50)]],
      email: [
        '',
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
}
