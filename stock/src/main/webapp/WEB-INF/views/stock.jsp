<%@page import="com.spring.stock.entity.Stock" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>stock</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--<
        link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <script src="main.js"></script>-->
</head>
<body>
    <%Stock stock = (Stock)request.getAttribute("stock"); %>
    company name:<%out.print(stock.getName());%><br><br>
    company code:<%out.print(stock.getCode());%><br><br>
    current rate:<%out.print(stock.getCurrentRate());%><br><br>
    previous close:<%out.print(stock.getPreviousClose());%><br><br>
    today open:<%out.print(stock.getTodayOpen());%><br><br>
    bid price:<%out.print(stock.getBidPrice());%><br><br>
    bid volume:<%out.print(stock.getBidVolume());%><br><br>
    ask price:<%out.print(stock.getAskPrice());%><br><br>
    ask volume:<%out.print(stock.getAskVolume());%><br><br>
    market volume:<%out.print(stock.getMarketVolume());%>
</body>
</html>