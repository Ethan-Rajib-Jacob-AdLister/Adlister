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

@WebServlet(name = "controllers.EditVGamesServlet", urlPatterns = "/ads/edit")
public class EditVGamesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        int EditGame = Integer.parseInt(request.getParameter("gameID2"));
        try {
            VGames vGames = DaoFactory.getVgsDao().findById(EditGame);
            request.setAttribute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
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

}



