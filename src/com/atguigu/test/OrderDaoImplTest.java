package com.atguigu.test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;
import org.jsoup.select.CombiningEvaluator;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrderDaoImplTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao=new OrderDaoImpl();
        orderDao.saveOrder(new Order("7829220",new Date(),new BigDecimal(5200),1,3));
    }

    @Test
    public void queryOrders() {
        OrderDao orderDao=new OrderDaoImpl();
        List<Order> list=orderDao.queryOrders();
        System.out.println(list);
    }

    @Test
    public void changeOrderStatus() {
        OrderDao orderDao=new OrderDaoImpl();
        orderDao.changeOrderStatus("7829220",2);
    }

    @Test
    public void queryOrderByUserId() {
        OrderDao orderDao=new OrderDaoImpl();
        List<Order> list=orderDao.queryOrderByUserId(1);
        System.out.println(list);
    }
}