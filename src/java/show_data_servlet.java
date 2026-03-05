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
import java.sql.*;


/**
 *
 * @author RUDRA PATEL
 */
public class show_data_servlet extends HttpServlet {

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
        String query = "select uname,upassword from usertable";
        Connection con = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost/user","root","user123123");
            stmt = con.createStatement();
           PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>uname</th>");
            out.println("<th>upassword</th>");
            out.println("</tr>");
        
        while(rs.next())
        {
            out.println("<tr>");
            out.println("<td>"+rs.getString("uname")+"</td>");
            out.println("<td>"+rs.getString("upassword")+"</td>");
            out.println("</tr>");
            
        }
        out.println("</table>");
      }
        catch(Exception e){}
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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   

}
