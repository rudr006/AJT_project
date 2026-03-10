<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="UTF-8">
        <title>Find Lost Item</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

        <style>

            body{
                background:#f5f7fa;
            }

            .form-card{
                margin-top:60px;
            }

        </style>

    </head>

    <body>

        <div class="container">

            <div class="row justify-content-center">

                <div class="col-md-6">

                    <div class="card shadow form-card">

                        <div class="card-header bg-danger text-white text-center">
                            <h3>Find Your Lost Item</h3>
                        </div>

                        <div class="card-body">

                            <h5 class="text-center mb-4">Search Result</h5>

                            <form action="findServlet" method="get">

                                <div class="mb-3">
                                    <label class="form-label">Item Name</label>
                                    <input type="text" name="itemName" class="form-control" placeholder="Item Name">
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Color</label>
                                    <input type="text" name="color" class="form-control" placeholder="Color">
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Description</label>
                                    <input type="text" name="description" class="form-control" placeholder="Description">
                                </div>

                                <div class="d-grid gap-2">

                                    <button type="submit" class="btn btn-success">
                                        Search Item
                                    </button>

                                    <button type="reset" class="btn btn-secondary">
                                        Clear
                                    </button>

                                </div>

                            </form>

                            <hr>

                            <div class="text-center">
                                <a href="welcome.jsp" class="btn btn-primary">
                                    Back to Dashboard
                                </a>
                            </div>

                        </div>

                    </div>

                </div>

            </div>

        </div>

    </body>
</html>x