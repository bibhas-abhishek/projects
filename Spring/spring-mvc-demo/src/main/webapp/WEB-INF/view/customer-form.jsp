<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
    <title>Customer Registration</title>
    <style>
    .error{color:red}
    </style>
</head>
<body>
    <h2>Customer Registration</h2>
    <hr/>
    <form:form action="processForm" modelAttribute="customer">
        First Name: <form:input path="firstName" />
        </br></br>
        Last Name (*): <form:input path="lastName" />
        <form:errors path="lastName" cssClass="error" />
        </br></br>
        Free Passes (*): <form:input path="freePasses" />
        <form:errors path="freePasses" cssClass="error" />
        </br></br>
        Course Code (*): <form:input path="courseCode" />
        <form:errors path="courseCode" cssClass="error" />
        </br></br>
        <input type="submit" value="Submit">
    </form:form>
</body>
</html>
