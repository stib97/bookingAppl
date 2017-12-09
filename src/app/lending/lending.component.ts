import { Component, OnInit } from '@angular/core';
import { NgModel } from '@angular/forms'; 

import { Lendings } from '../lendings';
import { LS } from '../mock-lendings';
import { LendingService } from '../lending.service';

import { Books } from '../books';
import { BS } from '../mock-books';
import { BookService } from '../book.service';

import { Movies } from '../movies';
import { MS } from '../mock-movies';
import { MovieService } from '../movie.service';

import { Users } from '../users';
import { US } from '../mock-users';
import { UserService } from '../user.service';


@Component({
  selector: 'app-lending',
  templateUrl: './lending.component.html',
  styleUrls: ['./lending.component.css']
})

export class LendingComponent implements OnInit {

  b: string;
  m: string;
  u: string;

  lendings: Lendings[];
  books: Books[];
  movies: Movies[];
  users: Users[];

  selectedLending: Lendings;

  constructor(private lendingService: LendingService, private bookservice: BookService, private movieService: MovieService,
                private userService: UserService) { }

  ngOnInit() {
    this.getLendings();
    this.getBooks();
    this.getMovies();
    this.getUsers();
  }

  onSelect(lending: Lendings): void {
    this.selectedLending = lending;
    const i = this.selectedLending.bookid;
    const j = this.selectedLending.movieid;
    const k = this.selectedLending.userid;
    
    if(i != null){
      for (let book of this.books){
        if(book.id == i){
          this.b = book.title;
        }
      }
    }
    else {
      this.b = null;
    }

    if(j != null){
      for (let movie of this.movies){
        if(movie.id == j){
          this.m = movie.title;
        }
      }
    }
    else {
      this.m = null;
    }

    for (let user of this.users){
      if(user.id == k){
        this.u = user.name;
      }
    }

  }

  getLendings(): void {
    this.lendingService.getLendings()
      .subscribe(lendings => this.lendings = lendings);
  }

  getBooks(): void {
    this.bookservice.getBooks()
      .subscribe(books => this.books = books);
  }

  getMovies(): void {
    this.movieService.getMovies()
      .subscribe(movies => this.movies = movies);
  }

  getUsers(): void {
    this.userService.getUsers()
      .subscribe(users => this.users = users);
  }

  addLending(date: NgModel, bookId: NgModel, movieId: NgModel, userId: NgModel){
    const index = this.lendings.length + 1;
    this.lendingService.add({id: index, date: date.value , bookid: bookId.value, movieid: movieId.value, userid: userId.value });
    date.reset();
    bookId.reset();
    movieId.reset();
    userId.reset();
  }

  removeLending(lending){
    this.lendingService.remove(lending);
  }


}
