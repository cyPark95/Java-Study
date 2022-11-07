package me.pcy.jpaexample;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceMockitoTest {

    @Test
    public void di() {
        BookRepository bookRepositoryMock = mock(BookRepository.class);
        Book hibernateBook = new Book();
        hibernateBook.setTitle("Hibernate");

        when(bookRepositoryMock.save(any())).thenReturn(hibernateBook);

        BookServiceSpring bookService = new BookServiceSpring(bookRepositoryMock);

        Book book = new Book();
        book.setTitle("spring");
        Book saveBook = bookService.returnBook(book);

        assertThat(saveBook.getTitle()).isEqualTo(hibernateBook.getTitle());
    }
}