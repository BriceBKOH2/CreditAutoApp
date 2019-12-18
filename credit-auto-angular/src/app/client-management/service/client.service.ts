import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Client } from 'src/app/calculation/class/client';
import { BehaviorSubject, Observable } from 'rxjs';
import { last } from 'rxjs/operators';

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

  findClient(id: number) {
    return this.httpClient.get<Client>(`${this.endPointClient}/${id}`);
  }

  findClientByNames(firsName: string, lastName: string) {
    const param = new HttpParams()
      .set('firstName', firsName)
      .set('lastName', lastName);

    return this.httpClient.get<Client[]>(`${this.endPointClient}/byname`, {
      params: param
    });
  }

  findClientByFirstName(firstName: string) {
    const param = new HttpParams().set('firstName', firstName);

    return this.httpClient.get<Client[]>(`${this.endPointClient}/byfirstname`, {
      params: param
    });
  }

  findClientByLastName(lastName: string) {
    const param = new HttpParams().set('lastName', lastName);

    return this.httpClient.get<Client[]>(`${this.endPointClient}/bylastname`, {
      params: param
    });
  }

  getNewAccountNumber() {
    return this.httpClient.get<number>(this.endPointClient);
  }
}
