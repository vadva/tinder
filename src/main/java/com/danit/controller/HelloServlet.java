package com.danit.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

//@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    private TemplateEngine templateEngine;

    public HelloServlet(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session != null) {
            String login = (String) session.getAttribute("login");
            if (login != null) {
                HashMap<String, Object> data = new HashMap<>(3);
                data.put("user", "user name");
                templateEngine.render("hello.ftl", data, resp);
                //req.getRequestDispatcher("/hello.ftl").forward(req, resp);
            } else {
                templateEngine.render("index.ftl", new HashMap<>(), resp);
                //req.getRequestDispatcher("/index.ftl").forward(req, resp);
            }
        }

    }
}
