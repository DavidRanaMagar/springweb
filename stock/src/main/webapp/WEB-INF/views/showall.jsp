<%@page import="com.spring.stock.entity.Stock" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stock List</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cookie">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700">
    <link rel="stylesheet" href="assets/css/Data-Table.css">
    <link rel="stylesheet" href="assets/css/Data-Table2.css">
    <link rel="stylesheet" href="assets/css/dh-header-non-rectangular.css">
    <link rel="stylesheet" href="assets/css/Dynamic-Table.css">
    <link rel="stylesheet" href="assets/css/Header-Blue--Sticky-Header--Smooth-Scroll.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/Pretty-Header.css">
    <link rel="stylesheet" href="assets/css/Pretty-Search-Form.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
    <nav class="navbar navbar-light navbar-expand-md custom-header" style="margin-bottom:20px;">
        <div class="container-fluid"><a class="navbar-brand" href="/" style="font-family:'Source Sans Pro', sans-serif;">Nepal Stock</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div
                class="collapse navbar-collapse" id="navbar-collapse">
                <ul class="nav navbar-nav ml-auto links">
                    <li class="nav-item" role="presentation"><a class="nav-link" href="logined">Login</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="logout">Logout</a></li>
                </ul>
        </div>
        </div>
    </nav>
    <div class="dynamic-table">
    <div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table table-bordered table-hover dynamic-table-tab_logic">
				<thead>
					<tr>
						<th class="text-center">
							SN
						</th>
						<th class="text-center">
							Company Name
						</th>
						<th class="text-center">
							Company Code
						</th>
						<th class="text-center">
							Previous Close
						</th>
						<th class="text-center">
							Today Open
						</th>
						<th class="text-center">
							Current Rate
						</th>
						<th class="text-center">
							Change
						</th>
					</tr>
				</thead>
				<%List<Stock> stockList=(List<Stock>) request.getAttribute("stockList"); 
                                int i=0;
                                for(Stock stock:stockList){
                                %>
				<tbody>
					<tr class='dynamic-table-addr0'>
						<td>
							<%out.print(++i);%>
						</td>
						<td>
                                                    <a href="getByName?companyName=<%=stock.getName() %>"><%out.print(stock.getName());%></a>
						</td>
						<td>
                                                    <a href="getByCode?companyCode=<%=stock.getCode() %>"><%out.print(stock.getCode());%></a>
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
						<td>
							<%out.print(stock.getCurrentRate()-stock.getPreviousClose());%>
						</td>
					</tr>
                    <tr class='dynamic-table-addr1'></tr>
				</tbody>
				<%}%>
			</table>
		</div>
	</div>
	
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
    <script src="assets/js/Dynamic-Table.js"></script>
    <script src="assets/js/Header-Blue--Sticky-Header--Smooth-Scroll.js"></script>
    <script src="assets/js/Header-Blue--Sticky-Header--Smooth-Scroll1.js"></script>
</body>

</html>