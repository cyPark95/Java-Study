package me.pcy.jpaexample;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

class BookServiceClassProxyTest_cglib {

    @Test
    public void di() {
        MethodInterceptor handler = new MethodInterceptor() {
            final DefaultBookService bookService = new DefaultBookService();

            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                if(method.getName().equals("rent")) {
                    System.out.println("== BookServiceProxy ==");
                    Object invoke = method.invoke(bookService, args);
                    System.out.println("== End ==");

                    return invoke;
                } else {
                    return method.invoke(bookService, args);
                }
            }
        };

        BookService bookService = (BookService) Enhancer.create(BookService.class, handler);

        Book book = new Book();
        book.setTitle("spring");

        bookService.rent(book);

        System.out.println();

        bookService.returnBook(book);
    }
}