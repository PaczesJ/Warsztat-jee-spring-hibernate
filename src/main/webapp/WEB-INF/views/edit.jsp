<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>EditBook</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    ISBN:
    <form:input path="isbn"/><br/>
    Title:
    <form:input path="title"/><br/>
    Author:
    <form:input path="author"/><br/>
    <input type="submit" value="EditBook">
</form:form>
</body>
</html>
