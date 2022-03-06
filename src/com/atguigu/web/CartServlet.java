package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet{

    private BookService bookService=new BookServiceImpl();

    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("加入购物车");
//        System.out.println("商品编号："+req.getParameter("id"));

        //获取请求的参数商品编号
        int id= WebUtils.parseInt(req.getParameter("id"),0);
        //调用bookService.queryBookById(id)得到图书信息
        Book book=bookService.queryBookById(id);
        //把图书信息转换成CartItem商品项
        CartItem cartItem=new CartItem(book.getId(), book.getName(), 1,book.getPrice(),book.getPrice());
        //调用Cart.addItem(CartItem)添加商品项
        Cart cart= (Cart) req.getSession().getAttribute("cart");
        if (cart==null){
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);
        //重定向返回商品列表页面
        resp.sendRedirect(req.getHeader("Referer"));
        req.getSession().setAttribute("lasstName",cartItem.getName());
    }

    /**
     * 删除商品项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品编号
        int id= WebUtils.parseInt(req.getParameter("id"),0);

        Cart cart= (Cart) req.getSession().getAttribute("cart");
        if (cart!=null){
            cart.deleteItem(id);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart= (Cart) req.getSession().getAttribute("cart");
        if (cart!=null){
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 修改商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= WebUtils.parseInt(req.getParameter("id"),0);
        int count=WebUtils.parseInt(req.getParameter("count"),1);

        Cart cart= (Cart) req.getSession().getAttribute("cart");
        if(cart!=null){
            cart.updateCount(id,count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("加入购物车");
//        System.out.println("商品编号："+req.getParameter("id"));

        //获取请求的参数商品编号
        int id= WebUtils.parseInt(req.getParameter("id"),0);
        //调用bookService.queryBookById(id)得到图书信息
        Book book=bookService.queryBookById(id);
        //把图书信息转换成CartItem商品项
        CartItem cartItem=new CartItem(book.getId(), book.getName(), 1,book.getPrice(),book.getPrice());
        //调用Cart.addItem(CartItem)添加商品项
        Cart cart= (Cart) req.getSession().getAttribute("cart");
        if (cart==null){
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

        req.getSession().setAttribute("lasstName",cartItem.getName());

        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("lastName",cartItem.getName());

        Gson gson=new Gson();
        String resultMapJson=gson.toJson(resultMap);
        resp.getWriter().write(resultMapJson);
    }
}
