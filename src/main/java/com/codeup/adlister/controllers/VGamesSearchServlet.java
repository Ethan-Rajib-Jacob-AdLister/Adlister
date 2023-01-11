package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "VGamesSearchServlet", urlPatterns = "/search")
public class VGamesSearchServlet extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException{
      String searchQ = request.getParameter("query");
      try {
         request.setAttribute("vgames", DaoFactory.getVgsDao().searchVGames(searchQ));
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
        request.getRequestDispatcher("WEB-INF/ads/index.jsp").forward(request, response);
    }
}

