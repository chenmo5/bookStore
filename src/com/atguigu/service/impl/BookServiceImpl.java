package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bookDao=new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deteBookById(Integer id) {
        bookDao.deteleBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book>page=new Page<Book>();

        page.setPageSize(pageSize);  //当前页显示量

        Integer pageTotalCount=bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);  //总记录数

//        Integer pageToatal=pageTotalCount%pageSize==0?pageTotalCount/pageSize:pageTotalCount/pageSize+1;
        Integer pageTotal=pageTotalCount/pageSize;
        if (pageTotalCount%pageSize>0){
            pageTotal+=1;
        }
        page.setPageTotal(pageTotal);  //总页码

        page.setPageNo(pageNo);

        int begin=(page.getPageNo()-1)*pageSize;
        List<Book> items=bookDao.quertForPageItems(begin,pageSize);
        page.setItems(items);  //当前页数据

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book>page=new Page<Book>();

        page.setPageSize(pageSize);  //当前页显示量

        Integer pageTotalCount=bookDao.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);  //总记录数

//        Integer pageToatal=pageTotalCount%pageSize==0?pageTotalCount/pageSize:pageTotalCount/pageSize+1;
        Integer pageTotal=pageTotalCount/pageSize;
        if (pageTotalCount%pageSize>0){
            pageTotal+=1;
        }
        page.setPageTotal(pageTotal);  //总页码

        page.setPageNo(pageNo);

        int begin=(page.getPageNo()-1)*pageSize;
        List<Book> items=bookDao.quertForPageItemsByPrice(begin,pageSize,min,max);
        page.setItems(items);  //当前页数据

        return page;
    }
}
