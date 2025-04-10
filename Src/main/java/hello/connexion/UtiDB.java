package connexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtiDB {
    private static final String URL = "jdbc:mysql://localhost:3306/db_s2_ETU003655";
    private static final String UTILISATEUR = "ETU003655";
    private static final String MOT_DE_PASSE = "cYf6hvlq";

    private UtiDB() {}

    public static Connection getInstance() {
        Connection connexion = null;
        if (connexion == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connexion = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println("Erreur de connexion : " + e.getMessage());
            }
        }
        return connexion;
    }
}
