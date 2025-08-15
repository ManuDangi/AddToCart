<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><c:choose><c:when test="${product.s_no ne null}">Edit Product</c:when><c:otherwise>Add New Product</c:otherwise></c:choose></title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        h1 { color: #333; }
        form {
            width: 50%;
            margin-top: 20px;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            background-color: #f9f9f9;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="number"] {
            width: calc(100% - 22px); /* Account for padding and border */
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box; /* Include padding and border in element's total width and height */
        }
        button {
            padding: 10px 20px;
            font-size: 16px;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #0056b3;
        }
        .back-link {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            color: #666;
        }
    </style>
</head>
<body>
    <h1><c:choose><c:when test="${product.s_no ne null}">Edit Product</c:when><c:otherwise>Add New Product</c:otherwise></c:choose></h1>

    <%-- Optional: Display success/error messages from RedirectAttributes --%>
    <c:if test="${not empty successMessage}">
        <p style="color: green; font-weight: bold;">${successMessage}</p>
    </c:if>
    <c:if test="${not empty errorMessage}">
        <p style="color: red; font-weight: bold;">${errorMessage}</p>
    </c:if>

    <form action="<c:url value='/products/save'/>" method="post">
        <c:if test="${product.s_no ne null}">
            <input type="hidden" name="s_no" value="${product.s_no}"/>
        </c:if>

        <label for="brandName">Brand Name:</label>
        <input type="text" id="brandName" name="brandName" value="${product.brandName}" required/><br/>

        <label for="description">Description:</label>
        <input type="text" id="description" name="description" value="${product.description}" required/><br/>

        <label for="typeOf">Type Of:</label>
        <input type="text" id="typeOf" name="typeOf" value="${product.typeOf}" required/><br/>

        <label for="price">Price:</label>
        <input type="number" id="price" name="price" value="${product.price}" required/><br/>

        <button type="submit">Save Product</button>
    </form>

    <p><a href="<c:url value='/products'/>" class="back-link">Back to Products List</a></p>
</body>
</html>