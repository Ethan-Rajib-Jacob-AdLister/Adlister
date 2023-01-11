package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
//import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.models.VGames;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.VGamesServlet", urlPatterns = "/ads/vgames")
public class VGamesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/vgames.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        VGames vg = new VGames(
                user.getId(),
                request.getParameter("title"),
                request.getParameter("con"),
                request.getParameter("genre"),
                request.getParameter("type"),
                request.getParameter("condition"),
                request.getParameter("price"),
                request.getParameter("description")
        );
        DaoFactory.getVgsDao().insert(vg);
        response.sendRedirect("/vgames");
    }
}

