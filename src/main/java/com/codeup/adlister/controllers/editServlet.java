package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.VGames;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="editServlet", urlPatterns = "/ads/editSetup")
public class editServlet extends HttpServlet {
    private int gameID = 0;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Start Get redirect");
        try {
//            req.setAttribute("editGame",DaoFactory.getVgsDao().getAGame(Integer.parseInt(req.getParameter("editGameID"))));
            System.out.println(gameID);
            VGames v1 = DaoFactory.getVgsDao().getAGame(gameID).get(0);
            req.setAttribute("editGame",v1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Before Get redirect");
        req.getRequestDispatcher("/WEB-INF/ads/editVGames.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setAttribute("editGame", req.getParameter("gameID2"));
        gameID = Integer.parseInt(req.getParameter("gameID2"));

        System.out.println("Before post redirect");
        resp.sendRedirect("/ads/editSetup");
    }
}
