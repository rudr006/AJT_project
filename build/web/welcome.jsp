<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <%
            String n = "";
            String m = "";

            n = request.getParameter("username");
            m = request.getParameter("password");
            
            if (n == null || n.equals("") || m == null || m.equals("")) {
                out.println("<h1>Please insert Data Correctly !!! </h1>");
//               
                RequestDispatcher rd = request.getRequestDispatcher("sign_up.jsp");
                rd.include(request, response);
                return;
            }
        %>
    </body>
</html>
