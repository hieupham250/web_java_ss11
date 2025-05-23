package com.example.ss11.repository;

import com.example.ss11.connection.ConnectionDB;
import com.example.ss11.model.Category;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImp implements CategoryRepository {
    @Override
    public List<Category> findAll() {
        Connection conn = null;
        CallableStatement cstmt = null;
        List<Category> categories = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call find_all_catalog()}");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                Category category = new Category(
                        rs.getInt("id"),
                        rs.getString("categoryName"),
                        rs.getBoolean("status")
                );
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return categories;
    }

    @Override
    public Category findById(int id) {
        Connection conn = null;
        CallableStatement cstmt = null;
       Category category = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call find_catalog_by_id(?)}");
            cstmt.setInt(1, id);
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
               category = new Category(
                        rs.getInt("id"),
                        rs.getString("categoryName"),
                        rs.getBoolean("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return category;
    }

    @Override
    public void save(Category category) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call create_catalog(?)}");
            cstmt.setString(1, category.getCategoryName());
            cstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
    }

    @Override
    public boolean existsByCategoryName(String name) {
        Connection conn = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        boolean exists = false;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call check_catalog_name(?)}");
            cstmt.setString(1, name);
            rs = cstmt.executeQuery();
            exists = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return exists;
    }

    @Override
    public void editCategory(Category category) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call edit_catalog(?, ?, ?)}");
            cstmt.setInt(1, category.getId());
            cstmt.setString(2, category.getCategoryName());
            cstmt.setBoolean(3, category.isStatus());
            cstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
    }

    @Override
    public boolean deleteCategory(int id) {
        Connection conn = null;
        CallableStatement cstmt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call delete_catalog(?)}");
            cstmt.setInt(1, id);
            cstmt.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return result;
    }
}
