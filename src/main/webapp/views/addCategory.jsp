<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thêm danh mục mới</h2>

<form:form method="post" modelAttribute="category">
    <label for="categoryName">Tên danh mục:</label>
    <form:input path="categoryName" id="categoryName"/>
    <form:errors path="categoryName" cssClass="error"/><br/><br/>
    <input type="submit" value="Lưu"/>
</form:form>

<a href="${pageContext.request.contextPath}/categories">← Quay lại danh sách</a>
</body>
</html>