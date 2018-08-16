<%--
  Created by IntelliJ IDEA.
  User: bibhas
  Date: 15/08/18
  Time: 5:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h2>Home Page Body</h2>
<p>
    User: <security:authentication property="principal.username"/>
    <br/><br/>
    Roles: <security:authentication property="principal.authorities"/>
</p>
<hr/>
<p>
    <security:authorize access="hasRole('manager')">
        <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
    </security:authorize>
    <br/>
    <br/>
    <security:authorize access="hasRole('admin')">
        <a href="${pageContext.request.contextPath}/systems">Admin Meeting</a>
    </security:authorize>
</p>
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="logout"/>
</form:form>
</body>
</html>
