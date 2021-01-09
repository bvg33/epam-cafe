<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 24.11.2020
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <link href="${pageContext.request.contextPath}/static/styles/header.css" type="text/css" rel="stylesheet">
</head>
<div class="header-panel">
    <div class="header-text">
        EPAM-cafe
    </div>
    <div class="header-image">
        <img src="static/images/Java.png" width="90" height="90">
    </div>
    <div class="top-tools">
        <div class="dropdown">
            <c:choose>
                <c:when test="${sessionScope.local=='en'}">
                    <button name="lang" class="dropbtn" type="submit">
                        <img src="static/images/usa.jpg" width="27" height="15">
                        EN
                    </button>
                </c:when>
                <c:when test="${sessionScope.local=='ru'}">
                    <button name="lang" class="dropbtn" type="submit">
                        <img src="static/images/ru.png" width="27" height="15">
                        RU
                    </button>
                </c:when>
                <c:when test="${sessionScope.local=='by'}">
                    <button name="lang" class="dropbtn" type="submit">
                        <img src="static/images/by.png" width="27" height="15">
                        BY
                    </button>
                </c:when>
            </c:choose>
            <div class="dropdown-content">
                <form action=${pageContext.request.contextPath}/controller method="get">
                    <c:choose>
                        <c:when test="${sessionScope.local=='ru'}">
                            <button name="lang" class="dropbtn" value="en">
                                <img src="static/images/usa.jpg" width="27" height="15">
                                EN
                            </button>

                            <button name="lang" class="dropbtn" value="by">
                                <img src="static/images/by.png" width="27" height="15">
                                BY
                            </button>
                        </c:when>

                        <c:when test="${sessionScope.local=='en'}">
                            <button name="lang" class="dropbtn" value="ru">
                                <img src="static/images/ru.png" width="27" height="15">
                                RU
                            </button>

                            <button name="lang" class="dropbtn" value="by">
                                <img src="static/images/by.png" width="27" height="15">
                                BY
                            </button>

                        </c:when>

                        <c:when test="${sessionScope.local=='by'}">
                            <button name="lang" class="dropbtn" value="en">
                                <img src="static/images/usa.jpg" width="27" height="15">
                                EN
                            </button>

                            <button name="lang" class="dropbtn" value="ru">
                                <img src="static/images/ru.png" width="27" height="15">
                                RU
                            </button>
                        </c:when>
                    </c:choose>
                    <input type="hidden" name="command" value="language"/>
                    <input type="hidden" name="path" value="${pageContext.request.servletPath}"/>
                </form>
            </div>
        </div>
        <fmt:setLocale value="${sessionScope.local}"/>
        <fmt:setBundle basename="localization.local" var="loc"/>
        <c:if test="${sessionScope.user!=null}">
            <form>
                <button type="submit"  class="profile" name="command" value="goToRolePage">
                        ${sessionScope.user.role}
                </button>
            </form>
            <form action=${pageContext.request.contextPath}/controller>
                <button type="submit" class="logout" name="command" value="logout">
                    <fmt:message bundle="${loc}" key="locale.logOutButton"/>
                </button>
            </form>
        </c:if>
    </div>
    <script src="${pageContext.request.contextPath}/static/js/HeaderButtons.js"></script>
</div>
