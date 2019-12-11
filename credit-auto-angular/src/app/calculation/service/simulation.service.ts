import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Rate } from '../class/rate';

import { Client } from '../class/client';
import { Category } from '../class/category';
import { Contract } from '../class/contract';

@Injectable({
  providedIn: 'root'
})
export class SimulationService {
  constructor(private httpClient: HttpClient) {}

  get endpointRate() {
    return 'http://localhost:8080/credit_auto/api/rate';
  }

  get endpointClient() {
    return 'http://localhost:8080/credit_auto/api/client';
  }

  get endpointCategory() {
    return 'http://localhost:8080/credit_auto/api/category';
  }

  postClient(client: Client) {
    return this.httpClient.post<Client>(this.endpointClient, client);
  }

  getRates(): Observable<Rate[]> {
    return this.httpClient.get<Rate[]>(this.endpointRate);
  }

  getRateForLoan(contract: Contract): Observable<Rate> {
    const params = new HttpParams()
      .set('contract', JSON.stringify(contract));

    console.log(params);

    return this.httpClient
      .get(`${this.endpointRate}/decision`, { params })
      .pipe(map((rate: Rate) => rate));
  }

   getCategories(): Observable<Category[]> {
    return this.httpClient
      .get<Category[]>(this.endpointCategory);
     }
}
