package me.pcy.jpaexample;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static net.bytebuddy.matcher.ElementMatchers.named;

class BookServiceClassProxyTest_bytebuddy {

    @Test
    public void di() throws Exception {
        Class<? extends DefaultBookService> proxyClass = new ByteBuddy().subclass(DefaultBookService.class)
                .method(named("rent")).intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
                    final DefaultBookService bookService = new DefaultBookService();

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("== BookServiceProxy ==");
                        Object invoke = method.invoke(bookService, args);
                        System.out.println("== End ==");

                        return invoke;
                    }
                }))
                .make().load(DefaultBookService.class.getClassLoader()).getLoaded();

        DefaultBookService bookService = proxyClass.getConstructor(null).newInstance();

        Book book = new Book();
        book.setTitle("spring");

        bookService.rent(book);

        System.out.println();

        bookService.returnBook(book);
    }
}