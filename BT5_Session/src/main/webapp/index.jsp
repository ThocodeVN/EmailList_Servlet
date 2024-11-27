<%-- 
    Document   : index
    Created on : Sep 26, 2024, 9:24:42 AM
    Author     : Duy Thanh
--%>

<%@page import="Database.CD"%>
<%@page import="Database.ListCD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<body>
    <c:import url="/header.html"/>
    
    <h1>CD list</h1>
    
    
    <%
        // Create an instance of ListCD
        ListCD listCD = new ListCD();
        // Get the CD list from the ListCD object
        java.util.ArrayList<CD> cdList = listCD.getListCD();
        // Set the CD list as a request attribute to use with JSTL
        request.setAttribute("cdList", cdList);
    %>
    
    <table>
        <thead>
            <tr>
                <th>Description</th>
                <th>Price</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <!-- Loop through the list of CDs and display each CD's details -->
            <c:forEach var="cd" items="${cdList}">
                <tr>
                    <td>${cd.name}</td>
                    <td>$${cd.price}</td>
                    <td>
                        <form action="CDServlet" method="post">
                            <input type="hidden" name="action" value="add">
                            <input type="hidden" name="name" value="${cd.name}">
                            <input type="hidden" name="price" value="${cd.price}">                                 
                            <button type="submit">Add To Cart</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
