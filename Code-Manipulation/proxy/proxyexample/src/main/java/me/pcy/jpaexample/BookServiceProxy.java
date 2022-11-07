package me.pcy.jpaexample;

public class BookServiceProxy implements BookService {

    private final BookService bookService;

    public BookServiceProxy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void rent(Book book) {
        System.out.println("== BookServiceProxy ==");
        bookService.rent(book);
        System.out.println("== End ==");
    }

    @Override
    public void returnBook(Book book) {
        bookService.returnBook(book);
    }
}
