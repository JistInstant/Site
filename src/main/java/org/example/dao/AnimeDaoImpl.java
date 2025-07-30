package org.example.dao;

import org.example.model.Anime;
import org.example.utils.DBManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimeDaoImpl implements AnimeDao {
    @Override
    public List<Anime> getAll() {
        List<Anime> list = new ArrayList<>();
        String sql = "SELECT * FROM anime";
        /*try with resiursces автоматически закроет
        Connection,Statement и Result
         */
        try { Connection conn = DBManager.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Anime a = new Anime();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setDescription(rs.getString("description"));
                a.setGenre(rs.getString("genre"));
                a.setRating(rs.getDouble("rating"));
                a.setImageUrl(rs.getString("image_url"));
                list.add(a);
            }
        }catch (SQLException e) {e.printStackTrace();}

        return list;
    }
    public Anime getById(int id){
        String sql = "SELECT * FROM anime WHERE id = ?";
        try(Connection c = DBManager.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
        Anime a = new Anime();
        a.setId(rs.getInt("id"));
        a.setTitle(rs.getString("title"));
        a.setDescription(rs.getString("description"));
        a.setGenre(rs.getString("genre"));
        a.setRating(rs.getDouble("rating"));
        a.setImageUrl(rs.getString("image_url"));
        return a;
        }

    } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
}}
