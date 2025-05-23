<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="registerB5" method="post" modelAttribute="form">
    <label>Tên:</label>
    <form:input path="name" />
    <form:errors path="name" cssClass="error"/>

    <label>Email:</label>
    <form:input path="email" />
    <form:errors path="email" cssClass="error"/>

    <label>Vai trò:</label>
    <form:select path="role">
        <form:option value="user" label="User"/>
        <form:option value="admin" label="Admin"/>
    </form:select>
    <form:errors path="role" cssClass="error"/>

    <!-- Hiển thị adminCode nếu role = admin -->
    <c:if test="${form.role == 'admin'}">
        <label>Mã admin:</label>
        <form:input path="adminCode" />
        <form:errors path="adminCode" cssClass="error"/>
    </c:if>

    <button type="submit">Đăng ký</button>
</form:form>


</body>
</html>
