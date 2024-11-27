<%@page import="java.util.ArrayList"%>
<%@page import="Database.CD"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Cart</title>
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
        td input[type="text"] {
            width: 50px;
            text-align: center;
        }
        td button {
            padding: 5px 10px;
            background-color: #ff4d4d;
            border: none;
            color: white;
            cursor: pointer;
        }
        td button:hover {
            background-color: #ff1a1a;
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
        .empty-cart {
            text-align: center;
            color: #888;
            font-size: 18px;
        }
    </style>
</head>
<body>

<h1>Your Cart</h1>

<!-- If cart is not empty, display the table -->
<c:if test="${not empty cart}">
    <form action="CDServlet" method="post">
        <table>
            <thead>
                <tr>
                    <th>Quantity</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Amount</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <!-- Loop through cart items -->
                <c:forEach var="item" items="${cart.getListLineCD()}">
                    <tr>
                        <td>
                            <form action="CDServlet" method="post">
                                <input type="hidden" name="action" value="update">
                                <input type="hidden" name="name" value="${item.name}">
                                <input type="hidden" name="price" value="${item.price}">
                                <input type="text" name="number" value="${item.number}" size="2"/>
                                <button type="submit">Update</button>
                            </form>                          
                        </td>
                        <td>${item.name}</td>
                        <td>$${item.price}</td>
                        <td>$${item.number * item.price}</td>
                        <td>
                            <form action="CDServlet" method="post">
                                <input type="hidden" name="action" value="remove">
                                <input type="hidden" name="name" value="${item.name}">
                                <button type="submit">Remove</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </form>
</c:if>

<!-- If cart is empty, display a message -->
<c:if test="${empty cart}">
    <p class="empty-cart">Your cart is empty!</p>
</c:if>

<!-- Buttons for navigation -->
<div class="actions">
    <form action="index.jsp" method="get">
        <button type="submit">Continue Shopping</button>
    </form>

    <form action="bill.jsp" method="get">
        <button type="submit">Checkout</button>
    </form>
</div>

</body>
</html>
