package me.pcy.jpaexample;

public interface BookService {

    void rent(Book book);

    void returnBook(Book book);
}
