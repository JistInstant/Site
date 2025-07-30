package org.example.dao;

import org.example.model.Anime;

import java.sql.SQLException;
import java.util.List;

public interface SavedAnimeDao {
    boolean isSavedAnime(int userId,int animeId) throws SQLException;
    void  addSavedAnime(int userId,int animeId) throws  SQLException;
    void removeSavedAnime(int userId,int animId) throws SQLException;
    List<Anime> getSavedAnime(int userId) throws SQLException;
}
