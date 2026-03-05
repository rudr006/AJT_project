/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.*;

/**
 *
 * @author RUDRA PATEL
 */
public class login_user_servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Connection con = null;
        Statement stmt = null;

        String n = "";
        String m = "";

        n = request.getParameter("uname");
        m = request.getParameter("password");

        try {
            if (n == null || n.equals("") || m == null || m.equals("")) {
                response.sendRedirect("index.html");
                return;
            }
            /* TODO output your page here. You may use following sample code. */
            Class.forName("com.mysql.cj.jdbc.Driver");

            out.println("<h1>successfully registered</h1>");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "user123123");

            stmt = con.createStatement();
            stmt.executeUpdate("insert into usertable values('" + n + "','" + m + "')");

            HttpSession session = request.getSession();
            session.setAttribute("user", n);

            out.println("<a href='show_data_servlet'>show</a>"+"  ");

            out.println("<button onclick=\"location.href='sign_up.jsp'\">Sign Up</button>");

        } catch (Exception e) {

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
}
