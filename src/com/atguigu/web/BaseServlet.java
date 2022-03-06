package com.atguigu.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String action=req.getParameter("action");

        try {
            //获取action业务鉴别字符串，获取相对的业务 方法反射现象
            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);   //调用目标业务方法
        } catch (Exception e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        }
//        if ("login".equals(action)){
//            login(req,resp);
//        }else if("regist".equals(action)){
//            regist(req,resp);
//        }
    }
}
