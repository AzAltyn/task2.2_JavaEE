<%@ page import="java.util.ArrayList" %>
<%@ page import="task2.Class.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BITLAB Shop</title>
    <%@include file="/vendor/head.jsp"%>
</head>
<body>
<%@include file="/vendor/navbar.jsp"%>
<div class="container">
    <div class="row mt-5">
        <div class="col-sm-12">
            <%
                Item item = (Item) request.getAttribute("item");
                if (item!=null){
            %>
                <div class="jumbotron">
                    <h1 class="display-4">
                        <%=item.getName()%>
                    </h1>
                    <p class="lead">Price: <%=item.getPrice()%> KZT</p>
                    <hr class="my-4">
                    <p>Amount: <%=item.getAmount()%></p>
                    <a class="btn btn-primary btn-sm" href="#" role="button">EDIT</a>
                </div>
            <%
                }
            %>
        </div>
    </div>
</div>
</body>
</html>
