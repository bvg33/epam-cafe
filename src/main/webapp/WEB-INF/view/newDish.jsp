<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 30.12.2020
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <title>New Dish</title>
    <link href="${pageContext.request.contextPath}/static/styles/newDish.css" type="text/css" rel="stylesheet">
</head>
<body>
<jsp:include page="templates/header.jsp"/>
<div class="workplace">
    <div class="page-info">
        <form enctype="multipart/form-data" method="post"
              action=${pageContext.request.contextPath}/controller?command=addNewDish>
            <div class="info">
                <label> <fmt:message bundle="${loc}" key="locale.tableColoumnName"/></label>
                <input placeholder="coffee"  name="name"  class="value" type="text" required="required">
            </div>
            <div class="info">
                <label> <fmt:message bundle="${loc}" key="locale.tableColoumnPrice"/></label>
                <input placeholder="2.5"  name="price"  class="value" type="text" required="required">
            </div>
            <div class="info">
                <label> <fmt:message bundle="${loc}" key="locale.tableColoumnPhoto"/></label>
                <input class="value" type="file" name="file" required="required">
            </div>
            <button class="add-dish" type="submit">Add new Dish</button>
        </form>
        <c:if test="${error=='WRONG_NAME'}">
            <div class="error">
                <fmt:message bundle="${loc}" key="locale.wrongName"/>
            </div>
        </c:if>
        <c:if test="${error=='WRONG_PRICE'}">
            <div class="error">
                <fmt:message bundle="${loc}" key="locale.wrongPrice"/>
            </div>
        </c:if>
    </div>
</div>
<jsp:include page="templates/adminSidebar.jsp"/>
</body>
</html>
