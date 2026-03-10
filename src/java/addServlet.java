
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

public class addServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/user",
                    "root",
                    "user123123");

            String itemName = request.getParameter("itemName");
            String color = request.getParameter("color");
            String place = request.getParameter("place");
            String description = request.getParameter("description");
            String contectNo = request.getParameter("contectNO");

            if (itemName == null || itemName.trim().isEmpty()
                    || color == null || color.trim().isEmpty()
                    || place == null || place.trim().isEmpty()
                    || description == null || description.trim().isEmpty()
                    || contectNo == null || contectNo.trim().isEmpty()) {

                response.sendRedirect("add.jsp");
                return;
            }

            String query = "INSERT INTO item(itemName,color,contectNo,place,description) VALUES(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, itemName);
            ps.setString(2, color);
            ps.setString(3, contectNo);
            ps.setString(4, place);
            ps.setString(5, description);

            int i = ps.executeUpdate();

            if (i > 0) {

//               
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.include(request, response);

                out.println("<br");
                out.println("<br");
                out.println("<br");
                out.println("<br");

                out.println("<div style='text-align:center; margin-top:40px;'>");
                out.println("<h1 style='color:green; background:#e9f7ef; padding:15px; border-radius:8px;'><center>You added the item successfully!</center></h1>");
                out.println("</div>");

            } else {
                out.println("Insert Failed");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            out.println(e);
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
