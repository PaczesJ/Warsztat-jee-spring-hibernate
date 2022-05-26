<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ShowBookDetails</title>
</head>
<body>
ISBN:${book.isbn}<br/>
Title:${book.title}<br/>
Author:${book.author}<br/>
<a href="/admin/books/all">BookList</a>
</body>
</html>
