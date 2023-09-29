import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IClienteRequest, IClienteResponse } from '../models/cliente.model';

@Injectable({
  providedIn: 'root',
})
export class ClienteService {
  constructor(private httpClient: HttpClient) {}
  private apiUrl = 'http://localhost:8080/cliente';

  getClientes(): Observable<IClienteResponse[]> {
    return this.httpClient.get<IClienteResponse[]>(`${this.apiUrl}`);
  }

  postCliente(clienteData: any): Observable<IClienteRequest> {
    return this.httpClient.post<IClienteRequest>(`${this.apiUrl}`, clienteData);
  }
}
