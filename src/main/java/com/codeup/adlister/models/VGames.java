package com.codeup.adlister.models;

import static java.lang.Integer.parseInt;

public class VGames {
    private long id;
    private long userId;
    private String title;
    private String description;
    private String console;
    private String genre;
    private String type;
    private String condition;
    private int price;

    public VGames(long id, long userId, String title, String description) {
        this.setId(id);
        this.setUserId(userId);
        this.setTitle(title);
        this.setDescription(description);
    }

    public VGames(long userId, String title, String description) {
        this.setUserId(userId);
        this.setTitle(title);
        this.setDescription(description);
    }

    public VGames(long id, long userId, String title, String console, String genre, String type, String condition, int price, String description) {
        this.setUserId(userId);
        this.setTitle(title);
        this.setConsole(console);
        this.setGenre(genre);
        this.setType(type);
        this.setCondition(condition);
        this.setPrice(price);
        this.setDescription(description);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
