import { Injectable } from '@angular/core';
import {
  CanActivate,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  UrlTree
} from '@angular/router';
import { Observable } from 'rxjs';
import { LocalstorageService } from '../service/localstorage.service';

@Injectable({
  providedIn: 'root'
})
export class IsSignedInGuard implements CanActivate {
  [x: string]: any;

  constructor(private localstorageService: LocalstorageService) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {
    return this.localstorageService.getCurrentUser() !== undefined;
    // if (this.localstorageService.getCurrentUser() !== 'empty') {
    //   return true;
    // }
    // return false;
  }
}
