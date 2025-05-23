<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách danh mục sản phẩm</h2>

<a href="${pageContext.request.contextPath}/categories/add">Thêm danh mục mới</a>
<br/><br/>

<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Tên danh mục</th>
        <th>Trạng thái</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="category" items="${categories}">
        <tr>
            <td>${category.id}</td>
            <td>${category.categoryName}</td>
            <td><c:choose>
                <c:when test="${category.status}">Hoạt động</c:when>
                <c:otherwise>Không hoạt động</c:otherwise>
            </c:choose></td>
            <td>
                <a href="${pageContext.request.contextPath}/categories/edit?id=${category.id}">Sửa</a> |
                <a href="${pageContext.request.contextPath}/categories/delete?id=${category.id}"
                   onclick="return confirm('Bạn có chắc chắn muốn xóa danh mục này?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>