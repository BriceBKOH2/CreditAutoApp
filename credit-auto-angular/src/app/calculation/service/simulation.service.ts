import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Rate } from '../class/rate';

import { Client } from '../class/client';

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

  postClient(client: Client) {
    let params = new HttpParams().set('client', JSON.stringify(client));
<<<<<<< HEAD

=======
>>>>>>> 80832450af2b1f15b9a99a404e4b8ffa66cee2a1
    console.log(params);

    return this.httpClient.post(this.endpointClient, { params });
  }

  getRates(): Observable<Rate[]> {
    return this.httpClient.get<Rate[]>(this.endpointRate);
  }

  getRateForLoan(): Observable<Rate> {
    let params = new HttpParams()
      .set('catId', '1')
      .set('price', '5000')
      .set('dur', '24');

    console.log(params);

    return this.httpClient
      .get(`${this.endpointRate}/decision`, { params })
      .pipe(map((rate: Rate) => rate));
  }
}
