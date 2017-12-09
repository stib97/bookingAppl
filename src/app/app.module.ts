import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { BooksComponent } from './books/books.component';
import { MoviesComponent } from './movies/movies.component';
import { LendingComponent } from './lending/lending.component';
import { UsersComponent } from './users/users.component';
import { HomePageComponent } from './home-page/home-page.component';
import { BookService } from './book.service';
import { UserService } from './user.service';
import { MovieService } from './movie.service';
import { LendingService } from './lending.service';

const appRoutes: Routes = [
  { path: 'home', component: HomePageComponent },
  { path: 'books', component: BooksComponent },
  { path: 'users', component: UsersComponent },
  { path: 'movies', component: MoviesComponent },
  { path: 'lendings', component: LendingComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
]

@NgModule({
  declarations: [
    AppComponent,
    BooksComponent,
    MoviesComponent,
    LendingComponent,
    UsersComponent,
    HomePageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule
  ],
  providers: [
    BookService,
    UserService,
    MovieService,
    LendingService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }