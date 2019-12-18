import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { IdentifiyingService } from '../service/identifiying.service';
import { LocalstorageService } from '../../service/localstorage.service';

import { User } from '../class/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {
  loading = false;
  submitted = false;
  returnUrl: string;
  user: User;

  loginForm = new FormGroup({
    login: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });

  constructor(
    private localstorageService: LocalstorageService,
    private identifiyingService: IdentifiyingService,
    private router: Router
  ) {}

  ngOnInit() {
    if (this.isUserLogged) {
      this.user = this.localstorageService.getCurrentUser();
    }
  }

  isUserLogged(): boolean {
    return this.localstorageService.getCurrentUser() !== undefined;
  }

  logOut() {
    this.identifiyingService.logOut();
    // console.log(this.localstorageService.getCurrentUser());
  }

  login() {
    this.user = new User(
      this.loginForm.get('login').value,
      this.loginForm.get('password').value
    );

    this.identifiyingService
      .login(this.user.login, this.user.password)
      .subscribe(response => {
        if (response === null) {
          console.log('Mauvais identifiants');
        } else {
          // si les identifiants sont bons
          // Storage on local storage
          this.localstorageService.storeCurrentUser(response);
          this.user = response;
          // this.router.navigate(['./simulPage']);
        }
      });
    console.log(this.user);

    // console.log(this.localstorageService.getCurrentUser());
  }
}
