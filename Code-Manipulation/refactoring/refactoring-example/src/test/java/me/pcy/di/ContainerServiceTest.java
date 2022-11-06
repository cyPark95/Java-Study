package me.pcy.di;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ContainerServiceTest {

    @Test
    public void getObject_BookRepository() {
        // given

        // when
        BookRepository bookRespository = ContainerService.getObject(BookRepository.class);

        // then
        assertNotNull(bookRespository);
    }

    @Test
    public void getObject_BookService() {
        // given

        // when
        BookService bookService = ContainerService.getObject(BookService.class);

        // then
        assertNotNull(bookService);
        assertNotNull(bookService.bookRepository);
    }
}
