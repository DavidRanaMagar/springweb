<%@page import="com.spring.stock.entity.Stock" %>
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
                <th>Company Name</th>
                <th>Code</th>
                <th>Bought Price</th>
                <th>Bought Volume</th>
                <th>Current Rate</th>
            </tr>
            <%List<BuyersTable> buyerList=(List<BuyersTable>) request.getAttribute("buyerList");
            <%Set<Stock> stockList=(Set<BuyersTable>) request.getAttribute("stockList");
            for(BuyersTable buyer:buyerList){
            %>
            
            <tr>
                <td>
                    <%for(Stock stock: stockList){
                        if (buyerList.getCode().equals(stock.getCode())){
                            out.print(stock.getName());%>
                </td>
                <td>
                    <%out.print(buyer.getCode());%>
                </td>
                <td>
                    <%out.print(buyer.getBoughtPrice());%>
                </td>
                <td>
                    <%out.print(buyer.getStockVolume());%>
                </td>
                <td>
                    <%out.print(stock.getCurrentRate());
                    }%>
                </td>
            </tr>
            <%}}%>
        </table>
</form>
</body>
</html>
