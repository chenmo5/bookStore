package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {

    private BookDao bookDao=new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"新书","小旭",new BigDecimal(999),1000,20,null));
    }

    @Test
    public void deteleBookById() {
        bookDao.deteleBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"新书","小民",new BigDecimal(999),100,20,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for(Book book: bookDao.queryBooks()){
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,50));
    }

    @Test
    public void quertForPageItems() {
        for (Book book:bookDao.quertForPageItems(8,4)){
            System.out.println(book);
        }
    }

    @Test
    public void quertForPageItemsByPrice() {
        for (Book book:bookDao.quertForPageItemsByPrice(0,4,10,50)){
            System.out.println(book);
        }
    }
}