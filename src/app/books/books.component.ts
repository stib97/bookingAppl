import { Component, OnInit, Input } from '@angular/core';
import { NgModel } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

import { Books } from '../books';
import { BS } from '../mock-books';
import { BookService } from '../book.service';

type Book = { id: number, title: string, author: string };

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})

export class BooksComponent implements OnInit {

    books: Books[];
  
    selectedBook: Books;
  
    constructor(private bookService: BookService) { }

  
    ngOnInit() {
      this.getBooks();
    }
  
    onSelect(book: Book): void {
      this.selectedBook = book;
    }
    
    getBooks(): void {
      this.bookService.getBooks()
        .subscribe(books => this.books = books);
    }

    addBook(bookTitle: NgModel, bookAuthor: NgModel){
      const index = this.books.length + 1;
      this.bookService.add({id: index, title: bookTitle.value , author: bookAuthor.value });
      bookTitle.reset();
      bookAuthor.reset();
    }

    removeBook(book){
      this.bookService.remove(book);
    }

  }
