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
<%@taglib prefix="ctg" uri="/WEB-INF/custom.tld" %>
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
                        <th><fmt:message bundle="${loc}" key="locale.dishes"/></th>
                        <th><fmt:message bundle="${loc}" key="locale.tableColoumnPrice"/></th>
                        <th><fmt:message bundle="${loc}" key="locale.issueTime"/></th>
                        <th><fmt:message bundle="${loc}" key="locale.state"/></th>
                        <th><fmt:message bundle="${loc}" key="locale.rating"/></th>
                        <th><fmt:message bundle="${loc}" key="locale.evaluateOrder"/></th>
                    </tr>
                    <c:forEach var="dish" items="${orders}">
                        <tr>
                            <td>${dish.getDishes()}</td>
                            <td>${dish.getPrice()} BYN</td>
                            <td>
                                <ctg:date date="${dish.getTime()}"/>
                            </td>
                            <td>
                                <fmt:message bundle="${loc}" key="locale.${dish.getState().getKey()}" var="currentDishState"/>
                                <label class="label">${currentDishState}</label>
                            </td>
                            <c:if test="${dish.getRating()==0}">
                                <form method="post"
                                      action="${pageContext.request.contextPath}/controller?command=evaluateOrder">
                                    <td>
                                        <div class="rating-area">
                                            <input type="radio" class="rating" id="star-1" name="rating" value="1">
                                            <label class="stars-label" for="star-5" title="Оценка «1»">1</label>
                                            <input type="radio" class="rating" id="star-2" name="rating" value="2">
                                            <label class="stars-label"  for="star-4" title="Оценка «2»">2</label>
                                            <input type="radio" class="rating" id="star-3" name="rating" value="3">
                                            <label class="stars-label"  for="star-3" title="Оценка «3»">3</label>
                                            <input type="radio" class="rating" id="star-4" name="rating" value="4">
                                            <label class="stars-label"  for="star-2" title="Оценка «4»">4</label>
                                            <input type="radio" class="rating" id="star-5" name="rating" value="5">
                                            <label class="stars-label"  for="star-1" title="Оценка «5»">5</label>
                                        </div>
                                    </td>
                                    <td>
                                        <button class="apply-button" type="submit"><fmt:message bundle="${loc}" key="locale.evaluateOrder"/></button>
                                    </td>
                                    <input type="hidden" name="orderId" value="${dish.getId()}">
                                </form>
                            </c:if>
                            <c:if test="${dish.getRating()!=0}">
                                <td class="order-rating-td"></td>
                                <input type="hidden" class="order-rating" name="rating" value="${dish.getRating()}">
                                <td><fmt:message bundle="${loc}" key="locale.alreadyEvaluated"/></td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </c:if>
    </div>
</div>
<jsp:include page="templates/sidebar.jsp"/>
<script src="${pageContext.request.contextPath}/static/js/StarsDrowing.js"></script>
</body>
</html>
