<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 25.12.2020
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bucket</title>
    <link href="${pageContext.request.contextPath}/static/styles/bucket.css" type="text/css" rel="stylesheet">
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
</head>
<body>
<jsp:include page="templates/header.jsp"/>
<div class="workplace">
    <div class="page-info">
        <c:if test="${sessionScope.bucket!=null && sessionScope.bucket.isEmpty()!=true}">
            <div class="page-info">
                <table id="table">
                    <tr>
                        <th><fmt:message bundle="${loc}" key="locale.tableColoumnName"/></th>
                        <th><fmt:message bundle="${loc}" key="locale.tableColoumnPrice"/> BYN</th>
                        <th><fmt:message bundle="${loc}" key="locale.tableColoumnAmount"/></th>
                        <th><fmt:message bundle="${loc}" key="locale.tableColoumnPhoto"/></th>
                        <th><fmt:message bundle="${loc}" key="locale.removeFromBucketButton"/></th>
                    </tr>
                    <c:forEach var="dish" items="${sessionScope.bucket}">
                        <tr>
                            <td>${dish.getName()}</td>
                            <td>${dish.getPrice()}</td>
                            <td>${dish.getCount()}</td>
                            <td><img src="static/images/${dish.getPhoto()}" width="80" height="80"></td>
                            <td>
                                <form>
                                    <button class="remove-button" type="submit" name="command"
                                            value="removeFromBucket">
                                        <fmt:message bundle="${loc}" key="locale.removeFromBucketButton"/>
                                    </button>
                                    <input type="hidden" name="id" value="${dish.getId()}">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <form>
                    <div class="cash">
                        <label><fmt:message bundle="${loc}" key="locale.cash"/></label>
                        <input type="radio" name="cash" value="cash" required="required">
                        <label><fmt:message bundle="${loc}" key="locale.noCash"/></label>
                        <input type="radio" name="cash" value="no_cash" required="required">
                    </div>
                    <div class="time">
                        <label for="start"> <fmt:message bundle="${loc}" key="locale.issueTime"/></label>
                        <input type="datetime-local" id="start" name="issue-time"
                               value="${minDate}"
                               min="${minDate}"
                               max="${maxDate}"
                               required="required">
                    </div>
                    <div class="cvc">
                        <label for="cvc-input"><fmt:message bundle="${loc}" key="locale.cvcInput"/></label>
                        <input id="cvc-input" type="password" placeholder="123" name="cvc" required="required">
                    </div>
                    </table>
                    <c:forEach var="dish" items="${sessionScope.bucket}">
                        <input type="hidden" name="dishId" value="${dish.getId()}">
                        <input type="hidden" name="count" value="${dish.getCount()}">
                        <c:set scope="page" var="currentPrice" value="${dish.getPrice()*dish.getCount()}"></c:set>
                        <c:set scope="page" var="sum" value="${pageScope.sum+pageScope.currentPrice}"></c:set>
                    </c:forEach>
                    <input type="hidden" name="command" value="makeAnOrder">
                    <input type="hidden" name="price" value="${sum}">
                    <button type="submit" class="pay-button" id="#openModal">
                        <fmt:message bundle="${loc}" key="locale.payButton"/> :${sum} BYN
                    </button>
                </form>
                <c:if test="${param.error==true}">
                    <div class="error">
                        <fmt:message bundle="${loc}" key="locale.wrongCVC"/>
                    </div>
                </c:if>
            </div>
        </c:if>
    </div>
</div>
<jsp:include page="templates/sidebar.jsp"/>
</body>
</body>
</html>
