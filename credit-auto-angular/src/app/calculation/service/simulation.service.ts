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

  get endPointRate() {
    return 'http://localhost:8080/credit_auto/api/rate';
  }

  get endPointClient() {
    return 'http://localhost:8080/credit_auto/api/client';
  }

  get endPointCategory() {
    return 'http://localhost:8080/credit_auto/api/category';
  }

  get endPointContract() {
    return 'http://localhost:8080/credit_auto/api/contract';
  }

  putClient(client: Client) {
    return this.httpClient.put<Client>(this.endPointClient, client);
  }

  getRates(): Observable<Rate[]> {
    return this.httpClient.get<Rate[]>(this.endPointRate);
  }

  getRateForLoan(contract: Contract): Observable<Rate> {
    let headers: HttpHeaders = new HttpHeaders();
    headers = headers.append('Accept', 'application/json');
    headers = headers.append('Content-Type', 'application/json');
    console.log('contract observable simul service');
    console.log(JSON.stringify(contract));

    return this.httpClient
      .post(`${this.endPointRate}/simulation`, JSON.stringify(contract), { headers })
      .pipe(map((rate: Rate) => rate));
  }

   getCategories(): Observable<Category[]> {
    return this.httpClient
      .get<Category[]>(this.endPointCategory);
     }
  
  gettotalAmount(contract: Contract): Observable<Contract> {
      let headers: HttpHeaders = new HttpHeaders();
      headers = headers.append('Accept', 'application/json');
      headers = headers.append('Content-Type', 'application/json');
      console.log('contract observable contract service');
      console.log(JSON.stringify(contract));
  
      return this.httpClient
        .post(`${this.endPointContract}`, JSON.stringify(contract), { headers })
        .pipe(map((amountDue: Contract) => amountDue));
    }

}
