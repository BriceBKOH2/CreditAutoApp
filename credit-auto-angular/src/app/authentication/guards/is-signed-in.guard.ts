import { Injectable } from '@angular/core';
import {
  CanActivate,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  UrlTree
} from '@angular/router';
import { Observable } from 'rxjs';
import { IdentifiyingService } from '../service/identifiying.service';

@Injectable({
  providedIn: 'root'
})
export class IsSignedInGuard implements CanActivate {
  constructor(private identifiyingService: IdentifiyingService) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {
    if (this.identifiyingService.isKnown) {
      return true;
    }
    return false;
  }
}
