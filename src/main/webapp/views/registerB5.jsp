<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ký</title>
</head>
<body>
<h2>Form Đăng Ký</h2>
<form:form action="registerB5" method="post" modelAttribute="form">
    <label>Tên:</label>
    <form:input path="name"/>
    <form:errors path="name"/>
    <br/>

    <label>Email:</label>
    <form:input path="email"/>
    <form:errors path="email" />
    <br/>

    <label>Vai trò:</label>
    <form:select path="role" id="roleSelect" onchange="toggleAdminCode()">
        <form:option value="" label="-- Chọn vai trò --"/>
        <form:option value="user" label="User"/>
        <form:option value="admin" label="Admin"/>
    </form:select>
    <form:errors path="role"/>
    <br/>

    <div id="adminCodeDiv" style="display: none;">
        <label>Mã admin:</label>
        <form:input path="adminCode"/>
        <form:errors path="adminCode" />
    </div>
    <br/>

    <button type="submit">Đăng ký</button>
</form:form>

<script>
    function toggleAdminCode() {
        const role = document.getElementById("roleSelect").value;
        const adminCodeDiv = document.getElementById("adminCodeDiv");
        adminCodeDiv.style.display = (role === 'admin') ? 'block' : 'none';
    }
    window.onload = toggleAdminCode;
</script>
</body>
</html>
