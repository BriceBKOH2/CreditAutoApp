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
  }

  getRateForLoan(): Observable<Rate> {
    let params = new HttpParams()
      .set('catId', '1')
      .set('price', '5000')
      .set('dur', '24');

    console.log(params);

    return this.httpClient
      .get(`${this.endPointRate}/decision`, { params })
      .pipe(map((rate: Rate) => rate));
  }
}
