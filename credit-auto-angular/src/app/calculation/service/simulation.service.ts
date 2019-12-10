import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Rate } from '../class/rate';
import { filter } from 'minimatch';

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
}
