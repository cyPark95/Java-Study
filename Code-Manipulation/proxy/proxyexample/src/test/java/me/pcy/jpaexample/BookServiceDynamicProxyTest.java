package me.pcy.jpaexample;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class BookServiceDynamicProxyTest {

    BookService defaultBookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(),
            new Class[]{BookService.class},
            new InvocationHandler() {
                final BookService bookService = new DefaultBookService();
    
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if(method.getName().equals("rent")) {
                        System.out.println("== BookServiceProxy ==");
                        Object invoke = method.invoke(bookService, args);
                        System.out.println("== End ==");

                        return invoke;
                    } else {
                        return method.invoke(bookService, args);
                    }
                }
            });

    @Test
    public void di() {
        Book book = new Book();
        book.setTitle("spring");

        defaultBookService.rent(book);

        System.out.println();

        defaultBookService.returnBook(book);
    }
}