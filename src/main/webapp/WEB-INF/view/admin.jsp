<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 27.12.2020
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin Page</title>
    <link href="${pageContext.request.contextPath}/static/styles/admin.css" type="text/css" rel="stylesheet">
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
</head>
<jsp:include page="templates/header.jsp"/>
<div class="workplace">
    <c:if test="${sessionScope.user!=null}">
        <div class="page-info">
            <table id="table">
                <tr>
                    <th><fmt:message bundle="${loc}" key="locale.name"/></th>
                    <th><fmt:message bundle="${loc}" key="locale.login"/></th>
                    <th><fmt:message bundle="${loc}" key="locale.loyality"/></th>
                    <th><fmt:message bundle="${loc}" key="locale.changeLoyality"/></th>
                    <th><fmt:message bundle="${loc}" key="locale.applyChanges"/></th>
                </tr>
                <c:forEach var="users" items="${users}">
                    <tr>
                        <td>${users.getName()}</td>
                        <td>${users.getLogin()}</td>
                        <td>${users.getLoyality()}</td>
                        <td>
                            <button class="minus-button">
                                -
                            </button>
                            <label class="loyality-points">0</label>
                            <button class="plus-button">
                                +
                            </button>
                        </td>
                        <td>
                            <form method="post" action=${pageContext.request.contextPath}/controller
                                  class="change-loyality">
                                <button class="apply-button" type="submit" name="command" value="updateLoyality">
                                    <fmt:message bundle="${loc}" key="locale.applyChanges"/>
                                </button>
                                <input type="hidden" name="id" value="${users.getId()}">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>
</div>
<jsp:include page="templates/adminSidebar.jsp"/>
<script src="${pageContext.request.contextPath}/static/js/LoyalityControll.js"></script>
</body>
</html>
