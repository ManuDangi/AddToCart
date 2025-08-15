<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart Application</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 50px; text-align: center; }
        h1 { color: #333; }
        .button {
            display: inline-block;
            padding: 10px 20px;
            margin: 10px;
            font-size: 16px;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Welcome to Your Shopping Cart Application!</h1>
    <p>This is your home page.</p>

    <p>
    <a href="<c:url value='/products'/>" class="button">View All Products</a>
</p>

    <!-- You can add more links/content related to the cart here later -->
</body>
</html>