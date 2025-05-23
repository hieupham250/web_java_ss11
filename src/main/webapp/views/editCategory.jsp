<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa danh mục</title>
</head>
<body>
<h2>Chỉnh sửa danh mục</h2>

<form:form action="${pageContext.request.contextPath}/categories/edit" modelAttribute="category" method="post">
    <form:hidden path="id"/>

    <div>
        <label>Tên danh mục:</label>
        <form:input path="categoryName"/>
        <form:errors path="categoryName" cssStyle="color:red"/>
    </div>

    <div>
        <label>Trạng thái:</label>
        <form:radiobutton path="status" value="true"/> Hoạt động
        <form:radiobutton path="status" value="false"/> Không hoạt động
    </div>

    <div>
        <input type="submit" value="Cập nhật"/>
        <a href="${pageContext.request.contextPath}/categories">Hủy</a>
    </div>
</form:form>
</body>
</html>
