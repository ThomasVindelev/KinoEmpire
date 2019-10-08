package com.kinoempire.demo.Model;

public class Movie {

    private int id;
    private String title;
    private String description;
    private int length;
    private int age_limit;
    private int genreId;
    private Genre genre;

    public Movie() {
    }

    public Movie(int id, String title, String description, int length, int age_limit, int genreId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.length = length;
        this.age_limit = age_limit;
        this.genreId = genreId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getAge_limit() {
        return age_limit;
    }

    public void setAge_limit(int age_limit) {
        this.age_limit = age_limit;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
