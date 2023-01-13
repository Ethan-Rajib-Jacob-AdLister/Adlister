package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.models.VGames;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "editServlet2", urlPatterns = "/ads/editCommit")
public class editServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        VGames vg = new VGames(
                Long.parseLong(request.getParameter("gameID")),
                user.getId(),
                request.getParameter("title"),
                request.getParameter("con"),
                request.getParameter("genre"),
                request.getParameter("type"),
                request.getParameter("condition"),
                request.getParameter("price"),
                request.getParameter("desc")
        );

        System.out.println(vg);

        try {
            DaoFactory.getVgsDao().update(vg);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("/vgames");
    }
}
