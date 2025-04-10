<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un Crédit</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <h1>Ajouter un nouveau crédit</h1>
        <form action="credit" method="post" class="form-container">
            <input type="hidden" name="action" value="ajouterCredit">
            
            <div class="form-group">
                <label for="libele">Libellé :</label>
                <input type="text" id="libele" name="libele" required>
            </div>
            
            <div class="form-group">
                <label for="montant">Montant :</label>
                <input type="number" id="montant" name="montant" step="0.01" min="0" required>
            </div>
            
            <button type="submit" class="btn btn-primary">Ajouter Crédit</button>
        </form>
        <div class="links">
            <a href="listeCredits.jsp" class="btn btn-secondary">Voir la liste des crédits</a>
            <a href="index.jsp" class="btn btn-secondary">Retour au tableau de bord</a>
        </div>
    </div>
</body>
</html>