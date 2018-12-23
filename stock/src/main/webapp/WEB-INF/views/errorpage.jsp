<%@page import="java.security.Principal"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cookie">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700">
    <link rel="stylesheet" href="assets/css/dh-header-non-rectangular.css">
    <link rel="stylesheet" href="assets/css/Header-Blue--Sticky-Header--Smooth-Scroll.css">
    <link rel="stylesheet" href="assets/css/Pretty-Header.css">
    <link rel="stylesheet" href="assets/css/Pretty-Search-Form.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
    <nav class="navbar navbar-light navbar-expand-md custom-header">
        <div class="container-fluid"><a class="navbar-brand" href="/" style="font-family:'Source Sans Pro', sans-serif;">Nepal Stock</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div
                class="collapse navbar-collapse" id="navbar-collapse">
                <ul class="nav navbar-nav ml-auto links">
                    <%  Principal p = request.getUserPrincipal();
                                String user = "Login";
                                String path = "login";
                                if (p!=null){
                                    user=p.getName().toString();
                                    path="userStock";
                                }%>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="<%out.print(path);%>"><%out.print(user);%></a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="logout">Logout</a></li>
                </ul>
        </div>
        </div>
    </nav>
    <h1>You Look Lost</h1>
    <h1><a href="/">Click Here</a> To Return Home</h1>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/Header-Blue--Sticky-Header--Smooth-Scroll.js"></script>
    <script src="assets/js/Header-Blue--Sticky-Header--Smooth-Scroll1.js"></script>
</body>

</html>

