
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.*;

public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        doPost(req, res); // redirect GET request to POST
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter out = res.getWriter();

        try {
            if (username == null || password == null || username.trim().isEmpty() || password.trim().isEmpty()) {
                res.sendRedirect("sign_up.jsp");
                return;
            }
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/user",
                    "root",
                    "user123123");

            String query = "SELECT * FROM usertable WHERE uname=? AND upassword=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                HttpSession session = req.getSession();
                session.setAttribute("user", username);
                res.sendRedirect("welcome.jsp");
            } else {
                out.println("<h1>" + "Invalid Username or Password" + "</h1>");

//               
                RequestDispatcher rd = req.getRequestDispatcher("sign_up.jsp");
                rd.include(req, res);
            }

        } catch (Exception e) {
            out.println(e);
        }
    }
}
