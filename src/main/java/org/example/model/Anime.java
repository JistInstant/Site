package org.example.model;


import java.util.List;

// Класс-модель для
// использования записи из таблицы anime
public class Anime implements BaseAnime{
    private int id;
    private String title;
    private String description;
    private String genre;
    private double rating;
    private String imageUrl;
    private transient boolean saved;
    public boolean isSaved() { return saved; }
    public void setSaved(boolean saved) { this.saved = saved; }
    public Anime() {
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }
    @Override
    public String getImageUrl() {
        return imageUrl;
    }

    private List<Episode> episodes;

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

}


