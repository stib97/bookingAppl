import { Component, OnInit } from '@angular/core';
import { NgModel } from '@angular/forms';

import { Movies } from '../movies';
import { MS } from '../mock-movies';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})

export class MoviesComponent implements OnInit {

  movies: Movies[];
  
  selectedMovie: Movies;

  constructor(private movieService: MovieService) { }

  ngOnInit() {
    this.getMovies();
  }

  onSelect(movie: Movies): void {
    this.selectedMovie = movie;
  }

  getMovies(): void {
    this.movieService.getMovies()
      .subscribe(movies => this.movies = movies);
  }

  addMovie(movieTitle: NgModel, movieYear: NgModel){
    const index = this.movies.length + 1;
    this.movieService.add({id: index, title: movieTitle.value , year: movieYear.value });
    movieTitle.reset();
    movieYear.reset();
  }

  removeMovie(movie){
    this.movieService.remove(movie);
  }

}

