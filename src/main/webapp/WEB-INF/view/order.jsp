<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 13.11.2020
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Order</title>
    <link href="${pageContext.request.contextPath}/static/styles/order.css" type="text/css" rel="stylesheet">
</head>
<body>
<jsp:include page="templates/header.jsp"/>
<jsp:include page="templates/sidebar.jsp"/>
<div class="workplace">
    <div class="page-info">
        <table id="table"></table>
        <ul id="pagination"></ul>
    </div>
</div>
<c:forEach var="user" items="${users}">
    <input type="hidden" class="allUsersNames" value="${user.getName()}"/>
    <input type="hidden" class="allUsersSurnames" value="${user.getSurname()}"/>
    <input type="hidden" class="allUsersAges" value="${user.getAge()}"/>
</c:forEach>
<script  src="${pageContext.request.contextPath}/static/js/Pagination.js"></script>
</body>
</html>