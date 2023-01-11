package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteVGamesServlet", urlPatterns = "/ads/delete")
public class DeleteVGamesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        request.getPathInfo().substring(1)
//        request.getParameter("gameID")
        System.out.println(request.getParameter("gameID"));
        int deleteGame = Integer.parseInt(request.getParameter("gameID"));
        try {
            DaoFactory.getVgsDao().deleteVGames(deleteGame);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/vgames");
    }
}