import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { Books } from './books';
import { BS } from './mock-books';


@Injectable()
export class BookService {

  private books: Books[];

  constructor() {
    this.books = BS;
   }

  getBooks(): Observable<Books[]> {
    return of(BS);
  }

  add(book: Books){
    this.books.push(book);
  }

  remove(book: Books){
    const index = this.books.indexOf(book);
    this.books.splice(index, 1);
  }

}