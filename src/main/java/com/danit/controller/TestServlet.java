package com.danit.controller;

import com.danit.dao.UserDao;
import com.danit.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestServlet extends HttpServlet {
    private UserDao userDao;
    private TemplateEngine templateEngine;
    private int Count = 0;
    List<HashMap> allUsers = new ArrayList<>();
    HashMap<String, Object> userData = new HashMap<>();
    HashMap<String, Object> userData1 = new HashMap<>();

    public TestServlet(UserDao userDao, TemplateEngine templateEngine) {
        this.userDao = userDao;
        this.templateEngine = templateEngine;
    }

//    User userNew = new User("Bevziuk", 35,"https://scontent-iev1-1.xx.fbcdn.net/v/t1.6435-9/40141568_292422678012921_8255249871049588736_n.jpg?_nc_cat=101&ccb=1-5&_nc_sid=8bfeb9&_nc_ohc=H3UZ3kCubHcAX856b5m&_nc_ht=scontent-iev1-1.xx&oh=047ca31d8306e8b4bd20cfc6043bd063&oe=61D53B0D");
//    User userNew1 = new User("Angela", 35,"https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/Angela_Merkel_2019_cropped.jpg/800px-Angela_Merkel_2019_cropped.jpg");
    User userNew = new User(1L,"Bevziuk", 35,1L,"1","1","https://scontent-iev1-1.xx.fbcdn.net/v/t1.6435-9/40141568_292422678012921_8255249871049588736_n.jpg?_nc_cat=101&ccb=1-5&_nc_sid=8bfeb9&_nc_ohc=H3UZ3kCubHcAX856b5m&_nc_ht=scontent-iev1-1.xx&oh=047ca31d8306e8b4bd20cfc6043bd063&oe=61D53B0D");
    User userNew1 = new User(2L,"Zayas", 39,1L,"1","1","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/Angela_Merkel_2019_cropped.jpg/800px-Angela_Merkel_2019_cropped.jpg");

    public void createUsers(){

        userDao.create(userNew);
        userDao.create(userNew1);

    }
    public HashMap setCurrentUser(){

        userDao.create(userNew);
        userDao.create(userNew1);

        userData.put("users", userNew);
        userData1.put("users", userNew1);

        allUsers.add(userData);
        allUsers.add(userData1);

        HashMap currentUser = allUsers.get(Count);
        return currentUser;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User all = userDao.read(1L);
        System.out.println(all);

        HashMap currentUser = setCurrentUser();
        templateEngine.render("hello_world.ftl", currentUser, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Count++;
        HashMap currentUser = setCurrentUser();
        templateEngine.render("hello_world.ftl", currentUser, resp);

    }
}
