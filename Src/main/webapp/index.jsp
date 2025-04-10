<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tableau de Bord - Gestion des Crédits et Dépenses</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            text-align: center;
        }
        h1 {
            color: #333;
        }
        .dashboard {
            margin-top: 30px;
        }
        .dashboard a {
            display: block;
            margin: 15px 0;
            padding: 10px 20px;
            background-color: #007BFF;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            width: 200px;
            margin-left: auto;
            margin-right: auto;
        }
        .dashboard a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Tableau de Bord</h1>
    <div class="dashboard">
        <a href="ajoutCredit.jsp">Ajouter un Crédit</a>
        <a href="ajoutDepense.jsp">Ajouter une Dépense</a>
        <a href="listeCredits.jsp">Voir la Liste des Crédits</a>
    </div>
</body>
</html>