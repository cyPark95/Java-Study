package me.pcy.jpaexample;

import org.springframework.stereotype.Service;

@Service
public class BookServiceSpring {

    final BookRepository bookRepository;

    public BookServiceSpring(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book returnBook(Book book) {
        return bookRepository.save(book);
    }
}
