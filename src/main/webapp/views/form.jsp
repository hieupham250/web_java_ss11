<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head><title>Form</title></head>
<body>
<h2>Thông tin người dùng</h2>
<form:form modelAttribute="user" action="submit" method="post">
    <p>
        Tên: <form:input path="name"/>
        <form:errors path="name" cssClass="error"/>
    </p>
    <p>
        Email: <form:input path="email"/>
        <form:errors path="email" cssClass="error"/>
    </p>
    <p>
        Số điện thoại: <form:input path="phone"/>
        <form:errors path="phone" cssClass="error"/>
    </p>
    <p>
        Mật khẩu: <form:password path="password"/>
        <form:errors path="password" cssClass="error"/>
    </p>
    <p>
        Trạng thái: <form:checkbox path="status"/> Hoạt động
    </p>
    <input type="submit" value="Gửi"/>
</form:form>
</body>
</html>

