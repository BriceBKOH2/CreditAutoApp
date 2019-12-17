import { Component, OnInit, Inject } from '@angular/core';
import { IdentifiyingService } from 'src/app/authentication/service/identifiying.service';
import { LOCAL_STORAGE, StorageService } from 'ngx-webstorage-service';
import { User } from 'src/app/authentication/class/user';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  user: User;

  constructor(private identifiyingService: IdentifiyingService) {}

  logOut() {
    this.identifiyingService.logOut();
  }

  ngOnInit() {
    this.user = this.identifiyingService.getCurrentUser();
  }
}
