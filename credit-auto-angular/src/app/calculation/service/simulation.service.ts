import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SimulationService {
  constructor(private httpClient: HttpClient) {}
  get endpoint() {
    return /*path for api simulation made in Java language*/;
  }

  //   get httpOption(){headers: HttpHeaders}{
  //   const headers = new HttpHeaders();
  //   return{headers};
  //   }
}
