import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, config } from 'rxjs';
import { User } from '../class/user';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class IdentifiyingService {
  isKnown = false;

  constructor(private httpClient: HttpClient) {}
  get endPointUser() {
    return 'http://localhost:8080/credit_auto/api/user';
  }

  login(user: User) {
    if (user.login === 'dav' && user.password === '0000') {
      this.isKnown = true;
      return true;
    }
    return false;
  }
}
