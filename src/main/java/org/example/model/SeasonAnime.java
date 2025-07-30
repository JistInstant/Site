package org.example.model;

// Добавили implements и поле description
public class SeasonAnime implements BaseAnime {
    private int id;
    private String title;
    private String imageUrl;
    private String description;    // если нужно
    private String genre;
    private Double rating;

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getRating() {
        return rating;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public SeasonAnime() {}

    @Override
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
