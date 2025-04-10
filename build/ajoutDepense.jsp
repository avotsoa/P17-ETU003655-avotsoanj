<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, model.Credit" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter une Dépense</title>
    <link rel="stylesheet" href="style2.css">
</head>
<body>
    <div class="container">
        <h1>Ajouter une nouvelle dépense</h1>
        <form action="depense" method="post" class="form-container">
            <input type="hidden" name="action" value="ajouterDepense">
            
            <div class="form-group">
                <label for="idCredit">Crédit :</label>
                <select id="idCredit" name="idCredit" required>
                    <option value="">Sélectionner un crédit</option>
                    <%
                        List<Credit> credits = Credit.findAll();
                        for (Credit credit : credits) {
                    %>
                        <option value="<%= credit.getIdCredit() %>"><%= credit.getLibele() %> (<%= credit.getMontant() %>)</option>
                    <% } %>
                </select>
            </div>
            
            <div class="form-group">
                <label for="libele">Libellé :</label>
                <input type="text" id="libele" name="libele" required>
            </div>
            
            <div class="form-group">
                <label for="montant">Montant :</label>
                <input type="number" id="montant" name="montant" step="0.01" min="0" required>
            </div>
            
            <button type="submit" class="btn btn-primary">Ajouter Dépense</button>
        </form>
        <div class="links">
            <a href="listeCredits.jsp" class="btn btn-secondary">Voir la liste des crédits</a>
            <a href="index.jsp" class="btn btn-secondary">Retour au tableau de bord</a>
        </div>
    </div>
</body>
</html>