<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 04.01.2021
  Time: 3:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Exception</title>
</head>
<body>
<h2>Exception occurred while processing the request</h2>
<p>Request from ${pageContext.errorData.requestURI}</p>
<p>Servlet name: ${pageContext.errorData.servletName}</p>
<p>Status code: ${pageContext.errorData.statusCode}</p>
<p>Exception: ${pageContext.exception}</p>
<p>Exception message: ${pageContext.exception.message}</p>
</body>
</html>
