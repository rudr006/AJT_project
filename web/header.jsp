<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    .header-bar{
        background: linear-gradient(to right, #1e3c72, #2a5298);
        color:white;
        padding:15px;
    }

    .header-title{
        font-size:28px;
        font-weight:bold;
    }

    .nav-link{
        color:white !important;
    }
</style>

<div class="header-bar">
    <div class="container d-flex justify-content-between align-items-center">

        <div class="header-title">
            Find Lost Portal
        </div>

        <div>
            <a href="welcome.jsp" class="nav-link d-inline me-3">Home</a>
            <a href="add.jsp" class="nav-link d-inline me-3">Add Item</a>
            <a href="find.jsp" class="nav-link d-inline me-3">Find Item</a>
            <a href="logoutServlet" class="nav-link d-inline">Logout</a>
        </div>

    </div>
</div>