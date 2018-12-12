<%@page import="com.spring.stock.entity.BuyersTable" %>
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
                <th>User Email</th>
                <th>Stock Code</th>
                <th>Bought Price</th>
                <th>Stock Volume</th>
                <th>Date</th>
                <th>Status</th>
            </tr>
            <%List<BuyersTable> buyersList=(List<BuyersTable>) request.getAttribute("buyersList"); 
            for(BuyersTable buyer:buyersList){
            %>
            
            <tr>
                <td>
                    <%out.print(buyer.getUserEmail());%>
                </td>
                <td>
                    <%out.print(buyer.getStockCode());%>
                </td>
                <td>
                    <%out.print(buyer.getBoughtPrice());%>
                </td>
                <td>
                    <%out.print(buyer.getStockVolume());%>
                </td>
                <td>
                    <%out.print(buyer.getDate());%>
                </td>
                <td>
                    <%out.print(buyer.getStatus());%>
                </td>
                <td>
                    <a href="confirmSellStock?id=<%=buyer.getId() %>">Confirm Sell</a>
                </td>
            </tr>
            <%}%>
        </table>
</form>
</body>
</html>
