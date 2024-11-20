/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package murach.email;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Duy Thanh
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/test"})
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         // Set the content type of the response
        response.setContentType("text/html");

        // Get the writer object to write the response
        PrintWriter out = response.getWriter();

        // Write the response message
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>TestServlet Get</h1>");
        out.println("</body>");
        out.println("</html>");
    }
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         // Set the content type of the response
        response.setContentType("text/html");

        // Get the writer object to write the response
        PrintWriter out = response.getWriter();

        // Write the response message
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>TestServlet Post</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
