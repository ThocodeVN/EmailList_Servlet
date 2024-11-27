<%@ page import="java.util.ArrayList" %>
<%@ page import="Database.Cart" %>
<%@ page import="Database.CD" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Bill</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f9f9f9;
        }
        h1 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        .total {
            font-size: 20px;
            font-weight: bold;
            text-align: right;
        }
        .actions {
            display: flex;
            justify-content: space-between;
        }
        .actions button {
            padding: 10px 15px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        .actions button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<h1>Your Bill</h1>

<!-- Display cart items if available -->
<c:set var="cart" value="${sessionScope.cart}" />
<c:if test="${not empty cart}">
    <table>
        <thead>
            <tr>
                <th>Description</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Amount</th>
            </tr>
        </thead>
        <tbody>
            <!-- Loop through cart items -->
            <c:forEach var="item" items="${cart.getListLineCD()}">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.number}</td>
                    <td>$${item.price}</td>
                    <td>$${item.number * item.price}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Total Price -->
    <div class="total">
        Total: $${cart.calculateTotal()}
    </div>
</c:if>

<!-- If cart is empty, display a message -->
<c:if test="${empty cart}">
    <p>Your cart is empty!</p>
</c:if>

<!-- Actions for navigation -->
<div class="actions">
    <!-- Button to continue shopping -->
    <form action="index.jsp" method="get">
        <button type="submit">Continue Shopping</button>
    </form>
</div>

</body>
</html>
