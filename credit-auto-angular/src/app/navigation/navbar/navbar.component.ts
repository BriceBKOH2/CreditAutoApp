import { Component, OnInit, Inject } from '@angular/core';
import { IdentifiyingService } from 'src/app/authentication/service/identifiying.service';
import { LOCAL_STORAGE, StorageService } from 'ngx-webstorage-service';
import { User } from 'src/app/authentication/class/user';
import { NavbarDisplayService } from '../service/navbar-display.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  isCollapsed = true;
  user: User;
  navbarDisplay: Observable<boolean>;

  constructor(
    private identifiyingService: IdentifiyingService,
    private navbarDisplayService: NavbarDisplayService
  ) {}

  logOut() {
    this.identifiyingService.logOut();
  }

  ngOnInit() {
    this.user = this.identifiyingService.getCurrentUser();
    this.navbarDisplay = this.navbarDisplayService.onChangeDisplay();
  }
}
