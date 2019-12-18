import { Injectable, Inject } from '@angular/core';
import { LOCAL_STORAGE, StorageService } from 'ngx-webstorage-service';
import { User } from '../authentication/class/user';

// key that is used to access the data in local storage
const CURRENT_USER = 'loggedUser';

@Injectable({
  providedIn: 'root'
})
export class LocalstorageService {
  constructor(@Inject(LOCAL_STORAGE) private storage: StorageService) {}

  public storeCurrentUser(user: User): void {
    // On store l'objet User dans le tableau associatif
    // LOCAL_STORAGE à la clé CURRENT_USER.
    this.storage.set(CURRENT_USER, user);
  }

  public clearCurrentUser() {
    this.storage.remove(CURRENT_USER);
  }

  public getCurrentUser() {
    return this.getLocalStorage(CURRENT_USER);
  }

  /**
   * Returns the value corresponding to the key in LOCAL_STORAGE or undefined
   * @param key
   */
  public getLocalStorage(key: string): any {
    return this.storage.get(key);
  }
}
