package com.codeup.adlister.dao;


import com.codeup.adlister.models.VGames;

import java.sql.SQLException;
import java.util.List;

public interface Vgs {
    // get a list of all the ads
    List<VGames> all();
    // insert a new ad and return the new ad's id
    List<VGames> searchVGames(String title) throws Exception;
    boolean deleteVGames(int id) throws Exception;
    Long insert(VGames vGames);

    VGames findById(long id) throws SQLException;

    void update(VGames vGames) throws SQLException;
}
