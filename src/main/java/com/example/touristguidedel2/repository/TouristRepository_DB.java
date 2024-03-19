package com.example.touristguidedel2.repository;

import com.example.touristguidedel2.model.TouristAttraction;
import com.example.touristguidedel2.util.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TouristRepository_DB {
    @Value("${spring.datasource.url}")
    String db_url;
    //private String db_url = "jdbc:mysql://jomtouristguide.mysql.database.azure.com:3306/touristguide";
    @Value("${spring.datasource.username}")
    String uid;
    //private String uid = "misc0001";
    @Value("${spring.datasource.password}")
    String pwd;
    //private String pwd ="MonsterHunter123";

    public List<TouristAttraction> getTouristAttractions() {
        List<TouristAttraction> attractions = new ArrayList<TouristAttraction>();
        String SQL = "SELECT * FROM touristattraction;";
// singleton
        Connection con = ConnectionManager.getConnection(db_url, uid, pwd);
        try (Statement stmt = con.createStatement();
// ikke nødvendig i try, da stmt.close også lukker Resultset
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                int ID = rs.getInt("id");
                String name = rs.getString("tname");
                String description = rs.getString("tdescription");
                String city = rs.getString("city");
                List<String> tags = Collections.singletonList(rs.getString("tags"));
                attractions.add(new TouristAttraction(ID, name, description, city, tags));
            }
            return attractions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public TouristAttraction addAttraction(TouristAttraction touristAttraction) {
        String SQL = "INSERT INTO touristattraction(tname, tdescription, city, tags) VALUES (?, ?, ?, ?);";
// singleton
        Connection con = ConnectionManager.getConnection(db_url, uid, pwd);
        try (PreparedStatement pstmt = con.prepareStatement(SQL)) {
            pstmt.setString(1, touristAttraction.getName());
            pstmt.setString(2, touristAttraction.getDescription());
            pstmt.setString(3, touristAttraction.getCity());
            pstmt.setString(4, touristAttraction.getTagsAsString());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return touristAttraction;
    }

    public boolean deleteAttraction(int id) {
        int rows = 0; // Antal rækker der er ændret
        String SQL = "DELETE FROM touristattraction WHERE ID = ?;";
// singleton
        Connection con = ConnectionManager.getConnection(db_url, uid, pwd);
        try (PreparedStatement pstmt = con.prepareStatement(SQL)) {
            pstmt.setInt(1, id);
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
// Returnerer true hvis en række er blevet slettet, ellers false
        return rows == 1;
    }

    public TouristAttraction updateAttraction(TouristAttraction touristAttraction) {
        int rows = 0; // antal rækker der er ændret
        String SQL = "UPDATE touristattraction SET touristattraction = ? WHERE ID = ? ;";
// singleton
        Connection con = ConnectionManager.getConnection(db_url, uid, pwd);
        try (PreparedStatement pstmt = con.prepareStatement(SQL);) {
            pstmt.setString(1, touristAttraction.getName());
            pstmt.setString(2, touristAttraction.getDescription());
            pstmt.setString(3, touristAttraction.getCity());
            pstmt.setString(4, touristAttraction.getTagsAsString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (rows == 1) // message fundet og opdateret
            return touristAttraction;
        else
            return null;
    }

    public boolean editAttraction(String name, TouristAttraction updatedAttraction) {
        String SQL = "UPDATE touristattraction SET tdescription = ?, city = ?, tags = ? WHERE tname = ?";
        int rowsAffected = 0;

        try (Connection con = ConnectionManager.getConnection(db_url, uid, pwd);
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setString(1, updatedAttraction.getDescription());
            pstmt.setString(2, updatedAttraction.getCity());
            pstmt.setString(3, updatedAttraction.getTagsAsString());
            pstmt.setString(4, name); // Navnet på turistattraktionen, der skal opdateres

            rowsAffected = pstmt.executeUpdate();

        } catch (SQLException e) {
            // Håndtering af databasefejl
            e.printStackTrace();
            return false;
        }

        return rowsAffected > 0; // Returner true hvis mindst én række blev opdateret
    }
}
