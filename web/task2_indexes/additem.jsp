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
                    String success = request.getParameter("success");
                    if (success!=null){
                %>
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <strong>Item added successfully!</strong> You can see this item in list.
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
                <%
                    }
                %>
                <form action="/addItem" method="post">
                    <div class="form-group">
                        <lable>NAME: </lable>
                        <input type="text" name="name" class="form-control">
                    </div>
                    <div class="form-group">
                        <lable>PRICE: </lable>
                        <input type="number" name="price" class="form-control">
                    </div>
                    <div class="form-group">
                        <lable>AMOUNT: </lable>
                        <input type="number" name="amount" class="form-control">
                    </div>
                    <div class="form-group">
                        <button class="btn btn-success">ADD ITEM</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
