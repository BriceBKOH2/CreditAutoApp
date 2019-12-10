import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Rate } from '../class/rate';
import { Contract } from '../class/contract';

@Injectable({
  providedIn: 'root'
})
export class SimulationService {
  constructor(private httpClient: HttpClient) {}

  get endpoint() {
    return 'http://localhost:8080/credit_auto/api/rate';
  }

  getRates(): Observable<Rate[]> {
    return this.httpClient.get<Rate[]>(this.endpoint);
  }

  getRateForLoan(): Observable<Rate> {
    let params = new HttpParams()
      .set('cat', '1')
      .set('price', '5000')
      .set('dur', '24');

    return this.httpClient
      .get(`${this.endpoint}/decision`, { params })
      .pipe(map((rate: Rate) => rate));
  }
}
