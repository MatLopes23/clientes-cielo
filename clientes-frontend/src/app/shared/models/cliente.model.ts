export interface IClienteResponse {
  id: string;
  cpf: string;
  nome: string;
  tipoCliente: string;
  email: string;
  mcc: string;
  cnpj: string;
  razaoSocial: string;
}

export interface IClienteRequest {
  tipoCliente: string;
  emailContato: string;
  cpfResponsavel: string;
  cnpj: string;
  razaoSocial: string;
  mcc: string;
  nomeResponsavel: string;
}

export enum TipoClienteEnum {
  PESSOA_FISICA = 'PESSOA_FISICA',
  PESSOA_JURIDICA = 'PESSOA_JURIDICA',
}
