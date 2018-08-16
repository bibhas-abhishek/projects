<%--
  Created by IntelliJ IDEA.
  User: bibhas
  Date: 15/08/18
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Form</title>
    <style>
        .failed {
            color: red;
        }
    </style>
</head>
<body>
<h3>Login Form</h3>
<form:form action="${pageContext.request.contextPath}/authenticateUser" method="post">
    <c:if test="${param.error != null}">
        <i class="failed">Invalid login credentials</i>
    </c:if>
    <table>
        <tr>
            <td>User Name:</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="login"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
