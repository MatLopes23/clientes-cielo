import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IClienteResponse } from '../models/cliente.model';

@Injectable({
  providedIn: 'root',
})
export class ClienteService {
  constructor(private httpClient: HttpClient) {}
  private apiUrl = 'http://localhost:8080/api/cliente';

  getClientes(): Observable<IClienteResponse[]> {
    return this.httpClient.get<IClienteResponse[]>(`${this.apiUrl}`);
  }
}
