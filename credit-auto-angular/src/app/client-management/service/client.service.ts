import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Rate } from 'src/app/calculation/class/rate';
import { Client } from 'src/app/calculation/class/client';
import { Category } from 'src/app/calculation/class/category';
import { Contract } from 'src/app/calculation/class/contract';



@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private httpClient: HttpClient) { }

  get endPointClient() {
    return 'http://localhost:8080/credit_auto/api/client';
  }

  putClient(client: Client) {
    return this.httpClient.put<Client>(this.endPointClient, client);
  }

}
