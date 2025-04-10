

import model.Credit;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CreditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("ajouterCredit".equals(action)) {
            String libele = request.getParameter("libele");
            double montant = Double.parseDouble(request.getParameter("montant"));
            try {
                Credit credit = new Credit(0, libele, montant);
                credit.save();
                response.sendRedirect("listeCredits.jsp");
            } catch (SQLException e) {
                throw new ServletException("Erreur lors de l'ajout du crédit", e);
            }
        }
    }
}