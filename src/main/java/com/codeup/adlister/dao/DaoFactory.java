package com.codeup.adlister.dao;

import com.codeup.adlister.Config;

public class DaoFactory {
    private static Vgs vgsDao;
    private static Ads adsDao;
    private static Users usersDao;
    private static Config config = new Config();

    public static Vgs getVgsDao() {
        if (vgsDao == null) {
            vgsDao = new MySQLVGamesDao(config);
        }
        return vgsDao;
    }

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }
}
