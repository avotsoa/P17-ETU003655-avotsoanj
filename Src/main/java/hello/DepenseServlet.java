

import model.Depense;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class DepenseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("ajouterDepense".equals(action)) {
            int idCredit = Integer.parseInt(request.getParameter("idCredit"));
            String libele = request.getParameter("libele");
            double montant = Double.parseDouble(request.getParameter("montant"));
            try {
                Depense depense = new Depense(0, idCredit, libele, montant);
                depense.save();
                response.sendRedirect("listeCredits.jsp");
            } catch (SQLException e) {
                throw new ServletException("Erreur lors de l'ajout de la dépense", e);
            }
        }
    }
}