
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

public class findServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/user",
                    "root",
                    "user123123"
            );

            String itemName = request.getParameter("itemName");
            String color = request.getParameter("color");

            if (itemName == null || itemName.trim().isEmpty()
                    || color == null || color.trim().isEmpty()) {

                response.sendRedirect("find.jsp");
                return;
            }

            String query = "select * from item where itemName=? AND color=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, itemName);
            ps.setString(2, color);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            /* ----------- HTML START ----------- */
            out.println("<html>");
            out.println("<head>");

            out.println("<title>Search Result</title>");

            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' rel='stylesheet'>");

            out.println("<style>");
            out.println("body{background:#f5f7fa;}");
            out.println(".header{background:#dc3545;color:white;padding:18px;text-align:center;font-size:28px;font-weight:bold;}");
            out.println("</style>");

            out.println("</head>");
            out.println("<body>");

            out.println("<div class='header'>Find Lost Portal</div>");

            out.println("<div class='container mt-5'>");

            while (rs.next()) {

                if (!found) {

                    found = true;

                    out.println("<table class='table table-bordered table-hover shadow'>");

                    out.println("<thead class='table-danger text-center'>");
                    out.println("<tr>");
                    out.println("<th>Item Name</th>");
                    out.println("<th>Color</th>");
                    out.println("<th>Contact No</th>");
                    out.println("<th>Place</th>");
                    out.println("<th>Description</th>");
                    out.println("</tr>");
                    out.println("</thead>");

                    out.println("<tbody class='text-center'>");
                }

                out.println("<tr>");
                out.println("<td>" + rs.getString("itemName") + "</td>");
                out.println("<td>" + rs.getString("color") + "</td>");
                out.println("<td>" + rs.getString("contectNo") + "</td>");
                out.println("<td>" + rs.getString("place") + "</td>");
                out.println("<td>" + rs.getString("description") + "</td>");
                out.println("</tr>");
            }

            if (found) {

                out.println("</tbody>");
                out.println("</table>");

            } else {

                out.println("<h4 class='text-center text-danger'>No item found for this search.</h4>");
            }

            out.println("<div class='text-center mt-4'>");

            out.println("<a href='find.jsp' class='btn btn-primary me-2'>Search Again</a>");

            out.println("<a href='welcome.jsp' class='btn btn-success'>Dashboard</a>");

            out.println("</div>");

            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

}
