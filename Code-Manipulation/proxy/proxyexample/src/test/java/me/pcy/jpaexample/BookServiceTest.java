package me.pcy.jpaexample;

import org.junit.jupiter.api.Test;

class BookServiceTest {

    BookService bookService = new BookServiceProxy(new DefaultBookService());

    @Test
    public void di() {
        Book book = new Book();
        book.setTitle("spring");

        bookService.rent(book);

        System.out.println();

        bookService.returnBook(book);
    }
}