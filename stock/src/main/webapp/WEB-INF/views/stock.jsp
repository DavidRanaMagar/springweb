<%@page import="com.spring.stock.entity.Stock" %>
<%@page import="java.security.Principal"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.spring.stock.entity.CompanyLog" %>
<%@page import="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
<%Stock stock = (Stock)request.getAttribute("stock"); %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%out.print(stock.getName());%></title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/Box-panels.css">
    <link rel="stylesheet" href="assets/css/Box-panels1.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cookie">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700">
    <link rel="stylesheet" href="assets/css/dh-header-non-rectangular.css">
    <link rel="stylesheet" href="assets/css/Header-Blue--Sticky-Header--Smooth-Scroll.css">
    <link rel="stylesheet" href="assets/css/Pretty-Header.css">
    <script src="assets/js/Chart.js"></script>
</head>

<body>
	<nav class="navbar navbar-light navbar-expand-md custom-header" style="margin-bottom:20px;">
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
    
    <div class="table-responsive">
    	<h1><%out.print(stock.getName());%></h1>
        <h3 ><%out.print(stock.getCode());%> (
            <%
                DecimalFormat df = new DecimalFormat("#.##");
                out.print(df.format(stock.getPreviousClose()-stock.getCurrentRate()));%>)</h3>
        <div class="chart" style="width: 60%;">
            <canvas id="myChart"></canvas>
        </div>
        <br>
        <br>
        
        <table class="table">
            <tbody>
                <tr>
                    <td>Open: <%out.print(stock.getTodayOpen());%></td>
                    <td>Last Close: <%out.print(stock.getPreviousClose());%></td>
                </tr>
                <tr>
                    <td >Current Rate: <%out.print(stock.getCurrentRate());%></td>
                </tr>
                <tr>
                    <td>Market Cap: <%out.print(stock.getMarketCap());%></td>
                    <td>Market Volume: <%out.print(stock.getMarketVolume());%></td>
                </tr>
                <tr>
                    <td>Bid Price: <%out.print(stock.getBidPrice());%></td>
                    <td>Bid Volume: <%out.print(stock.getBidVolume());%></td>
                </tr>
                <tr>
                    <td>Ask Price: <%out.print(stock.getAskPrice());%></td>
                    <td>Ask Volume: <%out.print(stock.getAskVolume());%></td>
                </tr>
            </tbody>
        </table>
                <a href="userBuyStock">Buy</a>
                <%session.setAttribute("rate",stock.getCurrentRate());
                session.setAttribute("code",stock.getCode());
                %>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
     <script src="assets/js/Header-Blue--Sticky-Header--Smooth-Scroll.js"></script>
    <script src="assets/js/Header-Blue--Sticky-Header--Smooth-Scroll1.js"></script>
    <script>
        var ctx = document.getElementById('myChart').getContext('2d');
        var chart = new Chart(ctx, {
        // The type of chart we want to create
        type: 'line',

        // The data for our dataset
        <%List<CompanyLog> chartDate = (List<CompanyLog>) request.getAttribute("chartDate");
        List<String> dateTime = new ArrayList<String>();
        List<Double> rate = new ArrayList<Double>();
        for (CompanyLog var: chartDate){
            dateTime.add("\""+var.getTime()+"\"");
            rate.add(var.getRate());
        }
        System.out.println(dateTime);
        System.out.println(rate);%>
                
        data: {
            labels:<%=dateTime%>,
            datasets: [{
                lable:"data",
                backgroundColor: 'rgb(150, 200, 255)',
                borderColor: 'rgb(150, 200, 255)',
                data:<%=rate%>,
        }]
        },

        // Configuration options go here
        options: {}
        });
    </script>
</body>

</html>


