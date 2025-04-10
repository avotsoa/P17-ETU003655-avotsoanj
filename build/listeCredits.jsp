<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, model.Credit, model.Depense" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Crédits et Dépenses</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { border-collapse: collapse; width: 80%; margin: 20px 0; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .total { font-weight: bold; }
    </style>
</head>
<body>
    <h1>Liste des Crédits avec leurs Dépenses</h1>
    <%
        List<Credit> credits = Credit.findAll();
        if (credits.isEmpty()) {
    %>
        <p>Aucun crédit trouvé.</p>
    <%
        } else {
            for (Credit credit : credits) {
                double totalDepenses = 0;
                List<Depense> depenses = Depense.findByCreditId(credit.getIdCredit());
                for (Depense depense : depenses) {
                    totalDepenses += depense.getMontant();
                }
                double reste = credit.getMontant() - totalDepenses;
    %>
        <h2><%= credit.getLibele() %> (Montant initial: <%= String.format("%.2f", credit.getMontant()) %>)</h2>
        <table>
            <tr>
                <th>Libellé Dépense</th>
                <th>Montant</th>
            </tr>
            <% for (Depense depense : depenses) { %>
            <tr>
                <td><%= depense.getLibele() %></td>
                <td><%= String.format("%.2f", depense.getMontant()) %></td>
            </tr>
            <% } %>
            <tr class="total">
                <td>Total Dépenses</td>
                <td><%= String.format("%.2f", totalDepenses) %></td>
            </tr>
            <tr class="total">
                <td>Reste</td>
                <td><%= String.format("%.2f", reste) %></td>
            </tr>
        </table>
    <%      }
        }
    %>
    <p><a href="ajoutCredit.jsp">Ajouter un crédit</a> | <a href="ajoutDepense.jsp">Ajouter une dépense</a></p>
    <p><a href="index.jsp">Retour au tableau de bord</a></p>
</body>
</html>