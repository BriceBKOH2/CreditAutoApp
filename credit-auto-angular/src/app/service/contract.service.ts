import { Injectable } from '@angular/core';
import { Contract } from '../calculation/class/contract';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContractService {

  constructor(private httpClient: HttpClient) {}

  get endPoint(): string {
    return 'http://localhost:8080/credit_auto/api/contract';
  }

  getContractFromClientId(id: number) {
    return this.httpClient.get<Contract[]>(
      `${this.endPoint}/client/${id}`
    );
  }

  searchById(id: number): Observable<Contract> {
    return this.httpClient.get<Contract>(
      `${this.endPoint}/${id}`
    );
  }
}
