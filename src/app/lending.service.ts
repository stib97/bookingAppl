import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { Lendings } from './lendings';
import { LS } from './mock-lendings';


@Injectable()
export class LendingService {

  private lendings: Lendings[];

  constructor() {
    this.lendings = LS;
   }

  getLendings(): Observable<Lendings[]> {
    return of(LS);
  }

  add(lending: Lendings){
    this.lendings.push(lending);
  }

  remove(lending: Lendings){
    const index = this.lendings.indexOf(lending);
    this.lendings.splice(index, 1);
  }


}
