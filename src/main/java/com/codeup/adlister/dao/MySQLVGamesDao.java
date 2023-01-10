package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.VGames;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLVGamesDao implements Vgs{
    private Connection connection = null;

    public MySQLVGamesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<VGames> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM game_store");
            ResultSet rs = stmt.executeQuery();
            return createVGamesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all games.", e);
        }
    }

    @Override
    public Long insert(VGames vGames) {
        try {
            String insertQuery = "INSERT INTO game_store(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, vGames.getUserId());
            stmt.setString(2, vGames.getTitle());
            stmt.setString(3, vGames.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new game.", e);
        }
    }

    private VGames extractVGames(ResultSet rs) throws SQLException {
        return new VGames(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("console"),
                rs.getString("genre"),
                rs.getString("type"),
                rs.getString("cond"),
                rs.getInt("price"),
                rs.getString("description")
        );
    }

    private List<VGames> createVGamesFromResults(ResultSet rs) throws SQLException {
        List<VGames> vgames = new ArrayList<>();
        while (rs.next()) {
            vgames.add(extractVGames(rs));
        }
        return vgames;
    }
}
