import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from 'src/app/calculation/class/client';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  constructor(private httpClient: HttpClient) {}

  get endPointClient() {
    return 'http://localhost:8080/credit_auto/api/client';
  }

  putClient(client: Client) {
    return this.httpClient.put<Client>(this.endPointClient, client);
  }

  getNewAccountNumber() {
    return this.httpClient.get<number>(this.endPointClient);
  }

  findClient(id: number) {
    return this.httpClient.get<Client>(`${this.endPointClient}/${id}`);
  }
}
