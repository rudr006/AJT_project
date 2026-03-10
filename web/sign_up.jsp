<!--
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="loginServlet" method="post">
            Username : <input type="text" name="username"/><br>
            Password : <input type="password" name="password" /><br>
            <input type="submit" value="submit" />
            <input type="reset" value="cancel" />
        </form>
    </body>
</html>


-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="UTF-8">
        <title>Find Lost Portal - Sign Up</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

        <style>

            body{
                background-color:#f5f7fa;
            }

            .signup-card{
                margin-top:120px;
            }

        </style>

    </head>

    <body>

        <div class="container">

            <div class="row justify-content-center">

                <div class="col-md-4">

                    <div class="card shadow signup-card">

                        <div class="card-header bg-danger text-white text-center">
                            <h3>Login</h3>
                        </div>

                        <div class="card-body">

                            <form action="loginServlet" method="post">

                                <div class="mb-3">
                                    <label class="form-label">Username</label>
                                    <input type="text" name="username" class="form-control" required>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Password</label>
                                    <input type="password" name="password" class="form-control" required>
                                </div>

                                <div class="d-grid mb-3">
                                    <button type="submit" class="btn btn-success">
                                        Login
                                    </button>
                                </div>

                                <div class="d-grid">
                                    <button type="reset" class="btn btn-secondary">
                                        Cancel
                                    </button>
                                </div>

                            </form>

                            <hr>

                            <div class="text-center">
                                <a href="index.html" class="btn btn-primary">Create an account</a>
                            </div>

                        </div>

                    </div>

                </div>

            </div>

        </div>

    </body>
</html>