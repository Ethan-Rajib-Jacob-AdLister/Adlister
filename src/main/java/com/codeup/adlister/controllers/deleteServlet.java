package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    Handles deleting of Video Game listings based on MYSQL id assigned to VideoGames
 */
@WebServlet(name = "deleteServlet", urlPatterns = "/ads/delete")
public class deleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int deleteGame = Integer.parseInt(request.getParameter("gameID"));
        // Prevent non-logged in users from deleting submissions
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        // TODO: Only allow users to delete their own listings
        try {
            DaoFactory.getVgsDao().deleteVGames(deleteGame);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/vgames");
    }
}