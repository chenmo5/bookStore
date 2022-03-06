package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderServiceImplTest {

    @Test
    public void createOrder() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"Java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"Java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"数据结构",1,new BigDecimal(100),new BigDecimal(100)));

        OrderService orderService=new OrderServiceImpl();
        System.out.println(orderService.createOrder(cart,1));
    }

    @Test
    public void showAllOrders() {
        OrderService orderService=new OrderServiceImpl();
        List<Order>list=orderService.showAllOrders();
        for (Order order : list) {
            System.out.println(order);
        }
    }

    @Test
    public void sendOrder() {
        OrderService orderService=new OrderServiceImpl();
        int a=orderService.sendOrder("123456789");
        System.out.println(a);
    }

    @Test
    public void showOrderDetail() {
        OrderService orderService=new OrderServiceImpl();
        List<OrderItem> orderItems=orderService.showOrderDetail("16461267843773");
        for(OrderItem orderItem:orderItems){
            System.out.println(orderItem);
        }
    }

    @Test
    public void showMyOrders() {
        OrderService orderService=new OrderServiceImpl();
        List<Order> orders=orderService.showMyOrders(1);
        for (Order order:orders){
            System.out.println(order);
        }
    }

    @Test
    public void receiverOrder() {
        OrderService orderService=new OrderServiceImpl();
        int a=orderService.receiverOrder("123456789");
        System.out.println(a);
    }
}