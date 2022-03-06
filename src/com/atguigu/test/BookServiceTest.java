package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService=new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"王图霸业","小民",new BigDecimal(9099),10200,50,null));
    }

    @Test
    public void deteBookById() {
        bookService.deteBookById(23);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"王图争霸","小民",new BigDecimal(999),1000,20,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for(Book book:bookService.queryBooks()){
            System.out.println(book);
        }
    }

    @Test
    public void page() {
        System.out.println(bookService.page(1,5));
    }
}