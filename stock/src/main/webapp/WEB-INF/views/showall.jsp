<%@page import="com.spring.stock.entity.Stock" %>
<%@page import="java.util.List" %>
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
    <table>
            <tr>
                <th>Company Name</th>
                <th>Code</th>
                <th>Previous Close</th>
                <th>Today Open</th>
                <th>Current Rate</th>
            </tr>
            <%List<Stock> stockList=(List<Stock>) request.getAttribute("stockList"); 
            for(Stock stock:stockList){
            %>
            
            <tr>
                <td>
                    <%out.print(stock.getName());%>
                </td>
                <td>
                    <%out.print(stock.getCode());%>
                </td>
                <td>
                    <%out.print(stock.getPreviousClose());%>
                </td>
                <td>
                    <%out.print(stock.getTodayOpen());%>
                </td>
                <td>
                    <%out.print(stock.getCurrentRate());%>
                </td>
            </tr>
            <%}%>
        </table>
</form>
</body>
</html>
