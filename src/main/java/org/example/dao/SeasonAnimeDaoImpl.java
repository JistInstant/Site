package org.example.dao;

import org.example.model.SeasonAnime;
import org.example.utils.DBManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeasonAnimeDaoImpl implements SeasonAnimeDao{
    @Override
    public List<SeasonAnime> getAll() {
        List<SeasonAnime> list = new ArrayList<>();
        String sql = "SELECT * FROM season_anime";
        try
                (Connection c = DBManager.getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()){
                SeasonAnime s = new SeasonAnime();
                s.setId(rs.getInt("id"));
                s.setTitle(rs.getString("title"));
                s.setImageUrl(rs.getString("image_url"));
                list.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public SeasonAnime getById(int id) {
        String sql = "SELECT * FROM season_anime WHERE id = ?";
        try (Connection c = DBManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                SeasonAnime s = new SeasonAnime();
                s.setId(rs.getInt("id"));
                s.setTitle(rs.getString("title"));
                s.setImageUrl(rs.getString("image_url"));
                s.setGenre(rs.getString("genre"));    // эти поля будут из SELECT *
                s.setRating(rs.getDouble("rating"));
                return s;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
