import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { IdentifiyingService } from '../service/identifiying.service';
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
    private identifiyingService: IdentifiyingService,
    private router: Router
  ) {}

  ngOnInit() {}

  login() {
    this.user = new User(
      this.loginForm.get('login').value,
      this.loginForm.get('password').value
    );
    console.log(this.user);
    console.log(this.identifiyingService.login(this.user));
    this.router.navigate(['./simulPage']);
  }
}
