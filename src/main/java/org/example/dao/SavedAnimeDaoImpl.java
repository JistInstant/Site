package org.example.dao;

import org.example.model.Anime;
import org.example.utils.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SavedAnimeDaoImpl implements SavedAnimeDao {

    @Override
    public boolean isSavedAnime(int userId, int animeId) throws SQLException {
        String sql = "SELECT 1 FROM saved_anime WHERE user_id = ? AND anime_id = ?";
        try(Connection conn = DBManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,userId);
            ps.setInt(2,animeId);
            try(ResultSet rs = ps.executeQuery()){
             return rs.next();
            }
        }
    }

    @Override
    public void addSavedAnime(int userId, int animeId) throws SQLException {
        String sql = "INSERT INTO saved_anime(user_id anime_id) VALUES(?,?)";
        try(Connection conn = DBManager.getConnection();PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setInt(1, userId);
            ps.setInt(2, animeId);
            ps.executeUpdate();
        }
    }

    @Override
    public void removeSavedAnime(int userId, int animId) throws SQLException {
        //SQL удаляет строку из таблицы saved_anime
        String sql = "DELETE FROM saved_anime WHERE user_id = ? AND anime_id = ? ";
        try(Connection conn = DBManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,userId);
            ps.setInt(2,animId); // Выполнит удаленгие
        }
    }

    @Override
    public List<Anime> getSavedAnime(int userId) throws SQLException {
        String sql = "SELECT a.* FROM anime a JOIN saved_anime sa ON a.id = sa.anime_id WHERE sa.user_id = ?";
        List<Anime> list = new ArrayList<>();
        try (  Connection conn = DBManager.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Anime anime = new Anime();
                    anime.setId(rs.getInt("id"));
                    anime.setTitle(rs.getString("title"));
                    anime.setImageUrl(rs.getString("image_url"));
                    anime.setGenre(rs.getString("genre"));
                    anime.setRating(rs.getDouble("rating"));
                    // помечаем как сохранённое
                    anime.setSaved(true);
                    list.add(anime);
                }
            }
        }
        return list;
    }
}

