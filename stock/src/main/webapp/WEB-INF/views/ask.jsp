<%@page import="java.security.Principal"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Set Ask Price</title>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="assets/css/Box-panels.css">
        <link rel="stylesheet" href="assets/css/Box-panels1.css">
        <link rel="stylesheet" href="assets/css/Responsive-Form.css">
        <link rel="stylesheet" href="assets/css/Responsive-Form1.css">
        <link rel="stylesheet" href="assets/css/styles.css">
        <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cookie">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700">
        <link rel="stylesheet" href="assets/css/dh-header-non-rectangular.css">
        <link rel="stylesheet" href="assets/css/Header-Blue--Sticky-Header--Smooth-Scroll.css">
        <link rel="stylesheet" href="assets/css/Pretty-Header.css">
        <link rel="stylesheet" href="assets/css/Pretty-Search-Form.css">
        <style>
            .page {
                display: grid;
                grid-template-columns: 1fr 5fr;
                grid-gap: 10px;
            }
            .side{
                padding: 10px;
                padding-top: 50px;
                border-right: 1px solid rgb(75, 73, 73);
            }
        </style>
    </head>

    <body>
        <nav class="navbar navbar-light navbar-expand-md custom-header" style="margin-bottom:20px;">
            <div class="container-fluid"><a class="navbar-brand" href="adminhome" style="font-family:'Source Sans Pro', sans-serif;">Nepal Stock</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
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
        <div class="page">
            <div class="side">
                <form action="getByName">
                    <h4>Stock Of </h4>
                    <input type="text" name="companyName" placeholder="Name of company">
                    <button type="submit">Search </button>
                </form><br>
                <a href="createStock">Create Stock</a><br>
                <a href="ask">Set Ask Rate</a><br>
                <a href="close">Set Close Rate</a><br>
                <a href="bid">Set Bid Rate</a><br>
                <a href="todayRate">Set Today Rate</a><br>
                <a href="marketVolume">Set Market Volume</a><br>
                <a href="marketCap">Set Market Cap</a><br>
                <a href="delete">Delete Stock</a><br>
                <a href="buyStock">Set Buy Stock</a><br>
                <a href="confirmSell">Conform Sell</a><br>
                <a href="showAll">All Stock</a><br>
            </div>
            <div class="main">
                <div class="container">
                    <div>
                        <form action="setAsk" method="POST">
                            <div class="form-group">
                                <div id="formdiv">
                                    <div class="form-row" style="margin-right:0px;margin-left:0px;padding-top:24px;">
                                        <div class="col-md-8 offset-md-1">
                                            <p style="margin-left:2%;font-family:Roboto, sans-serif;font-size:24px; color:black"><strong>Company Code</strong></p>
                                        </div>
                                        <div class="col-md-10 offset-md-1" style="font-family:Roboto, sans-serif;"><input class="form-control" type="text" name="companyCode" placeholder="code" style="margin-left:0px;"></div>
                                    </div>
                                    <div class="form-row" style="margin-right:0px;margin-left:0px;padding-top:24px;">
                                        <div class="col-md-8 offset-md-1">
                                            <p style="margin-left:2%;font-family:Roboto, sans-serif;font-size:24px; color:black"><strong>Ask Price</strong></p>
                                        </div>
                                        <div class="col-md-10 offset-md-1" style="font-family:Roboto, sans-serif;"><input class="form-control" type="text" name="askPrice" placeholder="Price" style="margin-left:0px;"></div>
                                    </div>
                                    <div class="form-row" style="margin-right:0px;margin-left:0px;padding-top:24px;">
                                        <div class="col-md-8 offset-md-1">
                                            <p style="margin-left:2%;font-family:Roboto, sans-serif;font-size:24px;color:black"><strong>Ask Volume</strong></p>
                                        </div>
                                        <div class="col-md-10 offset-md-1" style="font-family:Roboto, sans-serif;"><input class="form-control" type="text" name="askVolume" placeholder="Volume" style="margin-left:0px;"></div>
                                    </div>
                                    <div class="form-row" style="margin-right:0px;margin-left:0px;padding-top:24px;">
                                        <div class="col-12 col-md-4 offset-md-4"><button class="btn btn-light btn-lg" type="reset" style="font-family:Roboto, sans-serif;">Clear </button><button class="btn btn-light btn-lg" type="submit" style="margin-left:16px;">Submit </button></div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <script src="assets/js/jquery.min.js"></script>
            <script src="assets/bootstrap/js/bootstrap.min.js"></script>
            <script src="assets/js/Header-Blue--Sticky-Header--Smooth-Scroll.js"></script>
            <script src="assets/js/Header-Blue--Sticky-Header--Smooth-Scroll1.js"></script>
    </body>

</html>






