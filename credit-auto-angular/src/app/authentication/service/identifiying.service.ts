import { Injectable } from '@angular/core';

import { User } from '../class/user';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { LocalstorageService } from 'src/app/service/localstorage.service';
import { Router } from '@angular/router';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IdentifiyingService {
  constructor(
    private localstorageService: LocalstorageService,
    private httpClient: HttpClient,
    private router: Router
  ) {}

  get endPointUser() {
    return 'http://localhost:8080/credit_auto/api/user';
  }

  logOut() {
    this.localstorageService.clearCurrentUser();
    this.router.navigate(['./loginPage']);
  }

  // appelle l'api pour se log, renvoie un Observable<User> si réussi, null/undefined sinon
  login(login: string, password: string): Observable<User> {
    let headers: HttpHeaders = new HttpHeaders();
    headers = headers.append('Accept', 'application/json');
    headers = headers.append('Content-Type', 'application/json');

    let params = new HttpParams();
    params = params.append('login', login);
    params = params.append('password', password);

    return this.httpClient
      .post(`${this.endPointUser}/login`, 'body', {
        headers,
        params
      })
      .pipe(map((user: User) => user));
  }

  getCurrentUser(): User {
    return this.localstorageService.getCurrentUser();
  }
}
