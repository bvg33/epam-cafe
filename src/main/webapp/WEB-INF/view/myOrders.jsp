<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 01.12.2020
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>My Orders</title>
    <link href="${pageContext.request.contextPath}/static/styles/myOrders.css" type="text/css" rel="stylesheet">
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
</head>
<body>
<jsp:include page="templates/header.jsp"/>
<div class="workplace">
    <div class="page-info">
        <c:if test="${orders!=null && orders.isEmpty()!=true}">
            <div class="page-info">
                <table id="table">
                    <tr>
                        <th><fmt:message bundle="${loc}" key="locale.orderNumber"/></th>
                        <th><fmt:message bundle="${loc}" key="locale.dishes"/> BYN</th>
                        <th><fmt:message bundle="${loc}" key="locale.tableColoumnPrice"/></th>
                        <th><fmt:message bundle="${loc}" key="locale.issueTime"/></th>
                        <th><fmt:message bundle="${loc}" key="locale.state"/></th>
                    </tr>
                    <c:forEach var="dish" items="${orders}">
                        <tr>
                            <td>"${dish.getOrder_id()}"</td>
                            <td>"${dish.getDishes()}"</td>
                            <td>"${dish.getPrice()} BYN"</td>
                            <td>"${dish.getTime()}"</td>
                            <td>"${dish.getState()}"</td>
                            <td>
                                <div class="rating-area">
                                    <input type="radio" id="star-5" name="rating" value="5">
                                    <label for="star-5" title="Оценка «5»"></label>
                                    <input type="radio" id="star-4" name="rating" value="4">
                                    <label for="star-4" title="Оценка «4»"></label>
                                    <input type="radio" id="star-3" name="rating" value="3">
                                    <label for="star-3" title="Оценка «3»"></label>
                                    <input type="radio" id="star-2" name="rating" value="2">
                                    <label for="star-2" title="Оценка «2»"></label>
                                    <input type="radio" id="star-1" name="rating" value="1">
                                    <label for="star-1" title="Оценка «1»"></label>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </c:if>
    </div>
</div>
<jsp:include page="templates/sidebar.jsp"/>
</body>
</html>
