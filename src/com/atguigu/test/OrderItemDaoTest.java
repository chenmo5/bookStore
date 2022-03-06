package com.atguigu.test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao=new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100),"12178920"));
        orderItemDao.saveOrderItem(new OrderItem(null,"javaScript从入门到精通",2,new BigDecimal(100),new BigDecimal(200),"7829220"));
    }

    @Test
    public void queryOtherItemsByOrderId() {
        OrderItemDao orderItemDao=new OrderItemDaoImpl();
        List<OrderItem> list=orderItemDao.queryOtherItemsByOrderId("123456789");
        System.out.println(list);
    }

}