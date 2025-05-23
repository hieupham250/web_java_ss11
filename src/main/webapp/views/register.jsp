<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Form đăng ký</title>
    <style>
        .error { color: red; }
    </style>
</head>
<body>
<h2>Đăng ký</h2>

<form:form method="post" modelAttribute="userForm">

    <div>
        <form:label path="name">Tên:</form:label>
        <form:input path="name" />
        <form:errors path="name" cssClass="error" />
    </div>

    <div>
        <form:label path="email">Email:</form:label>
        <form:input path="email" />
        <form:errors path="email" cssClass="error" />
    </div>

    <div>
        <form:label path="password">Mật khẩu:</form:label>
        <form:password path="password" />
        <form:errors path="password" cssClass="error" />
    </div>

    <div>
        <button type="submit">Đăng ký</button>
    </div>

</form:form>
</body>
</html>
