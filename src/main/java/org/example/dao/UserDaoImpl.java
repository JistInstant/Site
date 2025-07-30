package org.example.dao;

import org.example.model.User;
import org.example.utils.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User findByUsername(String username) throws SQLException {
        String sql = "SELECT id,username, email,password_hash FROM users WHERE username = ?";
        try(Connection conn = DBManager.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setPasswordHash(rs.getString("password_hash"));
                    return user;
                }
                return null;
            }
        }
    }

    @Override
    public User findById(int id) throws SQLException {
        String sql = "SELECT id, username, email, password_hash FROM users WHERE id = ?";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setPasswordHash(rs.getString("password_hash"));
                    return user;
                }
                return null;
            }
        }
    }
}