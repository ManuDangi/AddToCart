<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products List</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        h1 { color: #333; }
        table { width: 90%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .action-links a { margin-right: 10px; text-decoration: none; color: #007bff; }
        .action-links a:hover { text-decoration: underline; }
        .button-link {
            display: inline-block;
            padding: 8px 15px;
            margin-bottom: 15px;
            font-size: 14px;
            color: #fff;
            background-color: #28a745;
            border: none;
            border-radius: 4px;
            text-decoration: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .button-link:hover {
            background-color: #218838;
        }
        .delete-form {
            display: inline;
        }
        .delete-button {
            background: none;
            border: none;
            color: #dc3545;
            text-decoration: underline;
            cursor: pointer;
            padding: 0;
            font-size: inherit;
            font-family: inherit;
        }
        .delete-button:hover {
            color: #c82333;
        }
    </style>
</head>
<body>
    <h1>All Products</h1>

    <p>
        <a href="<c:url value='/products/new'/>" class="button-link">Add New Product</a>
    </p>

    <%-- Optional: Display success/error messages from RedirectAttributes --%>
    <c:if test="${not empty successMessage}">
        <p style="color: green; font-weight: bold;">${successMessage}</p>
    </c:if>
    <c:if test="${not empty errorMessage}">
        <p style="color: red; font-weight: bold;">${errorMessage}</p>
    </c:if>

    <c:choose>
        <c:when test="${not empty products}">
            <table>
                <thead>
                    <tr>
                        <th>S.No</th>
                        <th>Brand Name</th>
                        <th>Description</th>
                        <th>Type Of</th>
                        <th>Price</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${products}">
                        <tr>
                            <td><c:out value="${product.s_no}"/></td>
                            <td><c:out value="${product.brandName}"/></td>
                            <td><c:out value="${product.description}"/></td>
                            <td><c:out value="${product.typeOf}"/></td>
                            <td><c:out value="${product.price}"/></td>
                            <td class="action-links">
                                <a href="<c:url value='/products/edit/${product.s_no}'/>">Edit</a>
                                <form class="delete-form" action="<c:url value='/products/delete/${product.s_no}'/>" method="post" onsubmit="return confirm('Are you sure you want to delete this product?');">
                                    
                                    <button type="submit" class="delete-button">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p>No products found in the database.</p>
        </c:otherwise>
    </c:choose>

    <p><a href="<c:url value='/'/>">Go to Home</a></p>
</body>
</html>