<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="UTF-8">
        <title>Find Lost Portal</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

        <style>

            body{
                background:#f5f7fa;
            }

            .header{
                background:#dc3545;
                color:white;
                padding:20px;
                text-align:center;
                font-size:32px;
                font-weight:bold;
            }

            .welcome-box{
                margin-top:80px;
                text-align:center;
            }

            .action-btn{
                width:280px;
                height:80px;
                font-size:22px;
                font-weight:bold;
            }

        </style>

    </head>

    <body>

        <div class="header">
            Find Lost Portal
        </div>

        <div class="container welcome-box">

            <h2 class="mb-5">You are logged in !!!</h2>

            <div class="row justify-content-center">

                <div class="col-md-3 text-center">
                    <button class="btn btn-success action-btn"
                            onclick="location.href = 'add.jsp'">
                        Add Lost Item
                    </button>
                </div>

                <div class="col-md-3 text-center">
                    <button class="btn btn-primary action-btn"
                            onclick="location.href = 'find.jsp'">
                        Find Lost Item
                    </button>
                </div>

            </div>

        </div>

    </body>
</html>