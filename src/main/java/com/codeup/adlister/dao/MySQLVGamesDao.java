package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
//import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.models.VGames;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLVGamesDao implements Vgs {
    private Connection connection = null;
    private String query;

    public static Connection con;

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
            String insertQuery = "INSERT INTO game_store(user_id, title, console, genre, type, cond, price, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, vGames.getUserId());
            stmt.setString(2, vGames.getTitle());
            stmt.setString(3, vGames.getConsole());
            stmt.setString(4, vGames.getGenre());
            stmt.setString(5, vGames.getType());
            stmt.setString(6, vGames.getCondition());
            stmt.setString(7, vGames.getPrice());
            stmt.setString(8, vGames.getDescription());
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
                rs.getString("price"),
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

// delete

    public boolean deleteVGames(int id2) throws SQLException {
        String sql = "DELETE FROM game_store WHERE id = " + id2 + ";";
        System.out.println(sql);
        PreparedStatement stmt = connection.prepareStatement(sql);

//        stmt.setInt(1, id);
        stmt.executeUpdate();

//        return createVGamesFromResults(rs);
        return false;
    }
    
    public List<VGames> searchVGames(String title) throws SQLException {
        String sql = "SELECT * FROM game_store WHERE title LIKE ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + title + "%");
            ResultSet rs = stmt.executeQuery();

            return createVGamesFromResults(rs);
        }
    public VGames findById(long id) throws SQLException {
        String userQ = "Select * from game_store where id = ? limit 1";
        PreparedStatement stmt = connection.prepareStatement(userQ);
        stmt.setString(1, String.valueOf(id));
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            return extractVGames(rs);
        }
        return null;
    }

    public void update(VGames vGames) throws SQLException {
        String q = "Update game_store set title = ?, console = ?, genre = ?, type = ?, cond = ?. price = ?, description = ? where id = ?";
        PreparedStatement stmt = connection.prepareStatement(q);
        stmt.setString(1, vGames.getTitle());
        stmt.setString(2, vGames.getConsole());
        stmt.setString(3, vGames.getGenre());
        stmt.setString(4, vGames.getType());
        stmt.setString(5, vGames.getCondition());
        stmt.setString(6, vGames.getPrice());
        stmt.setString(7, vGames.getDescription());
        stmt.executeUpdate();

    }
    }
