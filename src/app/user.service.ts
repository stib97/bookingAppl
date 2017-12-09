import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { Users } from './users';
import { US } from './mock-users';

@Injectable()
export class UserService {

  private users: Users[];

  constructor() {
    this.users = US;
   }

  getUsers(): Observable<Users[]> {
    return of(US);
  }

  add(user: Users){
    this.users.push(user);
  }

  remove(user: Users){
    const index = this.users.indexOf(user);
    this.users.splice(index, 1);
  }

}
