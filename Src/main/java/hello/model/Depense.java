package model;

import connexion.UtiDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Depense {
    private int idDepense;
    private int idCredit;
    private String libele;
    private double montant;

    public Depense(int idDepense, int idCredit, String libele, double montant) {
        this.idDepense = idDepense;
        this.idCredit = idCredit;
        this.libele = libele;
        this.montant = montant;
    }

    // Getters et Setters
    public int getIdDepense() { return idDepense; }
    public void setIdDepense(int idDepense) { this.idDepense = idDepense; }
    public int getIdCredit() { return idCredit; }
    public void setIdCredit(int idCredit) { this.idCredit = idCredit; }
    public String getLibele() { return libele; }
    public void setLibele(String libele) { this.libele = libele; }
    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }

    // Create
    public void save() throws SQLException {
        try (Connection conn = UtiDB.getInstance()) {
            String sql = "INSERT INTO Depense (id_credit, libele, montant) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, this.idCredit);
                stmt.setString(2, this.libele);
                stmt.setDouble(3, this.montant);
                stmt.executeUpdate();
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) this.idDepense = rs.getInt(1);
                }
            }
        }
    }

    // Read by ID
    public static Depense getById(int idDepense) throws SQLException {
        try (Connection conn = UtiDB.getInstance()) {
            String sql = "SELECT * FROM Depense WHERE id_depense = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idDepense);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    return new Depense(rs.getInt("id_depense"), rs.getInt("id_credit"), rs.getString("libele"), rs.getDouble("montant"));
                }
            }
        }
        return null;
    }

    // Find all by credit ID
    public static List<Depense> findByCreditId(int idCredit) throws SQLException {
        List<Depense> depenses = new ArrayList<>();
        try (Connection conn = UtiDB.getInstance()) {
            String sql = "SELECT * FROM Depense WHERE id_credit = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idCredit);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    depenses.add(new Depense(rs.getInt("id_depense"), rs.getInt("id_credit"), rs.getString("libele"), rs.getDouble("montant")));
                }
            }
        }
        return depenses;
    }

    // Update
    public void update() throws SQLException {
        try (Connection conn = UtiDB.getInstance()) {
            String sql = "UPDATE Depense SET id_credit = ?, libele = ?, montant = ? WHERE id_depense = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, this.idCredit);
                stmt.setString(2, this.libele);
                stmt.setDouble(3, this.montant);
                stmt.setInt(4, this.idDepense);
                stmt.executeUpdate();
            }
        }
    }

    // Delete
    public void delete() throws SQLException {
        try (Connection conn = UtiDB.getInstance()) {
            String sql = "DELETE FROM Depense WHERE id_depense = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, this.idDepense);
                stmt.executeUpdate();
            }
        }
    }

    @Override
    public String toString() {
        return "Depense [idDepense=" + idDepense + ", idCredit=" + idCredit + ", libele=" + libele + ", montant=" + montant + "]";
    }
}