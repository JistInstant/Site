package org.example.dao;

import org.example.model.Episode;
import org.example.utils.DBManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EpisodeDaoImpl implements EpisodeDao {
    @Override
    public List<Episode> getEpisodesBySeasonAnimeId(int seasonAnimeId) {
        List<Episode> episodes = new ArrayList<>();
        String sql = "SELECT * FROM episode WHERE season_anime_id = ?";

        try (Connection conn =  DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, seasonAnimeId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Episode ep = new Episode();
                ep.setId(rs.getInt("id"));
                ep.setAnimeId(rs.getInt("anime_id")); // можно не ставить
                ep.setTitle(rs.getString("title"));
                ep.setVideoUrl(rs.getString("video_url"));
                episodes.add(ep);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return episodes;
    }


    @Override
    public List<Episode> getEpisodesByAnimeId(int animeId) {
        List<Episode> episodes = new ArrayList<>();
        String sql = "SELECT * FROM episode WHERE anime_id = ? ORDER BY episode_number";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, animeId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Episode episode = new Episode();
                episode.setId(rs.getInt("id"));
                episode.setAnimeId(rs.getInt("anime_id"));
                episode.setEpisodeNumber(rs.getInt("episode_number"));
                episode.setTitle(rs.getString("title"));
                episode.setVideoUrl(rs.getString("video_url"));
                episodes.add(episode);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // можешь заменить логированием
        }

        return episodes;
    }
}
