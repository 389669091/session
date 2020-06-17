package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/success")
public class SuccessServlet extends HttpServlet {

    private static final String SESSION_KEY = "helloWord";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //做一个拦截，验证session中是否有登录信息
        HttpSession session = request.getSession();
        if (session != null) {
            Object obj = session.getAttribute(SESSION_KEY);
            if (obj != null) {
                //说明session中有登录信息（合法登录）
                request.getRequestDispatcher("/success.jsp").forward(request, response);
            }
        }else {
        System.out.println("非法登录");
        //说明session中没有登录信息（非法登录）
        //强制重新登录
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    }
}
