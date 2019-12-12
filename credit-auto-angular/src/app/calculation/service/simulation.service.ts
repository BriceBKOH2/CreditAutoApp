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

<<<<<<< HEAD
  get endPointRate() {
    return 'http://localhost:8080/credit_auto/api/rate';
  }

  get endPointClient() {
    return 'http://localhost:8080/credit_auto/api/client';
  }

  postClient(client: Client): Observable<Client> {
    return this.httpClient.post<Client>(this.endPointClient, client);
  }

  getRates(): Observable<Rate[]> {
    return this.httpClient.get<Rate[]>(this.endPointRate);
=======
  get endpointRate() {
    return 'http://localhost:8080/credit_auto/api/rate';
  }

  get endpointClient() {
    return 'http://localhost:8080/credit_auto/api/client';
  }

  postClient(client: Client) {
    let params = new HttpParams().set('client', JSON.stringify(client));
    console.log(params);

    return this.httpClient.post(this.endpointClient, { params });
  }

  getRates(): Observable<Rate[]> {
    return this.httpClient.get<Rate[]>(this.endpointRate);
>>>>>>> 80832450af2b1f15b9a99a404e4b8ffa66cee2a1
  }

  getRateForLoan(): Observable<Rate> {
    let params = new HttpParams()
      .set('catId', '1')
      .set('price', '5000')
      .set('dur', '24');

    console.log(params);

    return this.httpClient
<<<<<<< HEAD
      .get(`${this.endPointRate}/decision`, { params })
=======
      .get(`${this.endpointRate}/decision`, { params })
>>>>>>> 80832450af2b1f15b9a99a404e4b8ffa66cee2a1
      .pipe(map((rate: Rate) => rate));
  }
}
