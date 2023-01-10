package com.codeup.adlister.dao;


import com.codeup.adlister.models.VGames;

import java.util.List;

public interface Vgs {
    // get a list of all the ads
    List<VGames> all();
    // insert a new ad and return the new ad's id
    Long insert(VGames vGames);
}
