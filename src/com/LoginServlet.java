package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String SESSION_KEY = "helloWord";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //把登录信息放到session中
        String account = request.getParameter("account");
        HttpSession session = request.getSession();
        //默认是30分钟
        session.setMaxInactiveInterval(600);
        session.setAttribute(SESSION_KEY, account);
        System.out.println(session.getId());
        //
        request.getRequestDispatcher("/success").forward(request, response);
    }
}
