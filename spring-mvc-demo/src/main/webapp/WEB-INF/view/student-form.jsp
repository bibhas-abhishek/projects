<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>
</head>
<body>
    <h2>Student Registration</h2>
    <hr/>
    <form:form action="processForm" modelAttribute="student">
        First Name: <form:input path="firstName" />
        </br></br>
        Last Name: <form:input path="lastName" />
        </br></br>
        <input type="submit" value="Submit">
    </form:form>
</body>
</html>
