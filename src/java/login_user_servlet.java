
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.*;

public class login_user_servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String uname = request.getParameter("uname");
        String password = request.getParameter("password");

        Connection con = null;

        try {

            if (uname == null || uname.trim().isEmpty()
                    || password == null || password.trim().isEmpty()) {

                response.sendRedirect("index.html");
                return;
            }

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/user",
                    "root",
                    "user123123"
            );

            String query = "insert into usertable values(?,?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, password);
            ps.executeUpdate();

            HttpSession session = request.getSession();
            session.setAttribute("user", uname);

            /* ---------------- HTML PAGE ---------------- */
            out.println("<!DOCTYPE html>");
            out.println("<html>");

            out.println("<head>");
            out.println("<title>Registration Success</title>");

            out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css'>");

            out.println("<style>");
            out.println("body { background:#f5f7fa; font-family: Arial; }");
            out.println(".header { background:#dc3545; color:white; padding:20px; text-align:center; font-size:30px; font-weight:bold; }");
            out.println(".card { margin-top:100px; }");
            out.println("</style>");

            out.println("</head>");

            out.println("<body>");

            out.println("<div class='header'>");
            out.println("Find Lost Portal");
            out.println("</div>");

            out.println("<div class='container'>");

            out.println("<div class='row justify-content-center'>");

            out.println("<div class='col-md-6'>");

            out.println("<div class='card shadow'>");

            out.println("<div class='card-body text-center'>");

            out.println("<br>");

            out.println("<h2 class='text-success mb-4'>You are successfully registered!</h2>");

            out.println("<div class='d-grid gap-3'>");

            out.println("<br>");

            out.println("<a href='sign_up.jsp' class='btn btn-primary btn-lg'>Go To Login </a>");

            out.println("<br>");

            out.println("</div>");

            out.println("</div>");

            out.println("</div>");

            out.println("</div>");

            out.println("</div>");

            out.println("</div>");

            out.println("</body>");

            out.println("</html>");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
