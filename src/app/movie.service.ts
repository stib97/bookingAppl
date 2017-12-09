import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { Movies } from './movies';
import { MS } from './mock-movies';

@Injectable()
export class MovieService {

  private movies: Movies[];

  constructor() { 
    this.movies = MS;
  }

  getMovies(): Observable<Movies[]> {
    return of(MS);
  }

  add(movie: Movies){
    this.movies.push(movie);
  }

  remove(movie: Movies){
    const index = this.movies.indexOf(movie);
    this.movies.splice(index, 1);
  }

}
