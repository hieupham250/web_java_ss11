<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Kết quả</title></head>
<body>
<h2>Đăng ký thành công</h2>
<c:if test="${not empty user}">
    Tên: ${user.name} <br/>
    Email: ${user.email} <br/>
    SĐT: ${user.phone} <br/>
    Trạng thái: <c:choose>
    <c:when test="${user.status}">Hoạt động</c:when>
    <c:otherwise>Không hoạt động</c:otherwise>
</c:choose>
</c:if>

<c:if test="${not empty userForm}">
    Tên: ${userForm.name} <br/>
    Email: ${userForm.email} <br/>
    Mật khẩu: ${userForm.password} <br/>
</c:if>
</body>
</html>
