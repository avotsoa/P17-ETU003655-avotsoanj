package model;

import connexion.UtiDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Credit {
    private int idCredit;
    private String libele;
    private double montant;

    public Credit(int idCredit, String libele, double montant) {
        this.idCredit = idCredit;
        this.libele = libele;
        this.montant = montant;
    }

    // Getters et Setters
    public int getIdCredit() { return idCredit; }
    public void setIdCredit(int idCredit) { this.idCredit = idCredit; }
    public String getLibele() { return libele; }
    public void setLibele(String libele) { this.libele = libele; }
    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }

    // Create
    public void save() throws SQLException {
        try (Connection conn = UtiDB.getInstance()) {
            String sql = "INSERT INTO Credit (libele, montant) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, this.libele);
                stmt.setDouble(2, this.montant);
                stmt.executeUpdate();
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) this.idCredit = rs.getInt(1);
                }
            }
        }
    }

    // Read by ID
    public static Credit getById(int idCredit) throws SQLException {
        try (Connection conn = UtiDB.getInstance()) {
            String sql = "SELECT * FROM Credit WHERE id_credit = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idCredit);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    return new Credit(rs.getInt("id_credit"), rs.getString("libele"), rs.getDouble("montant"));
                }
            }
        }
        return null;
    }

    // Find all
    public static List<Credit> findAll() throws SQLException {
        List<Credit> credits = new ArrayList<>();
        try (Connection conn = UtiDB.getInstance()) {
            String sql = "SELECT * FROM Credit";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    credits.add(new Credit(rs.getInt("id_credit"), rs.getString("libele"), rs.getDouble("montant")));
                }
            }
        }
        return credits;
    }

    // Update
    public void update() throws SQLException {
        try (Connection conn = UtiDB.getInstance()) {
            String sql = "UPDATE Credit SET libele = ?, montant = ? WHERE id_credit = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, this.libele);
                stmt.setDouble(2, this.montant);
                stmt.setInt(3, this.idCredit);
                stmt.executeUpdate();
            }
        }
    }

    // Delete
    public void delete() throws SQLException {
        try (Connection conn = UtiDB.getInstance()) {
            String sql = "DELETE FROM Credit WHERE id_credit = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, this.idCredit);
                stmt.executeUpdate();
            }
        }
    }

    @Override
    public String toString() {
        return "Credit [idCredit=" + idCredit + ", libele=" + libele + ", montant=" + montant + "]";
    }
}