import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Rate } from '../interface/rate';
import { filter } from 'minimatch';

@Injectable({
  providedIn: 'root'
})
export class SimulationService {
  constructor(private httpClient: HttpClient) {}

  get endpoint() {
    return 'http://localhost:8080/credit_auto/api/rate';
  }

  getRate(
    carCat: string,
    carPrice: number,
    duration: number
  ): Observable<Rate> {
    return this.httpClient.get<Rate>(this.endpoint);
  }
}
