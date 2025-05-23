<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Form Đánh Giá</title>
</head>
<body>

<h2>Form Đánh Giá</h2>

<form:form method="post" modelAttribute="review">

    <label for="name">Tên:</label><br/>
    <form:input path="name" id="name" />
    <form:errors path="name" cssClass="error" /><br/><br/>

    <label for="email">Email:</label><br/>
    <form:input path="email" id="email" />
    <form:errors path="email" cssClass="error" /><br/><br/>

    <label for="rating">Đánh giá (1-5 sao):</label><br/>
    <form:input path="rating" id="rating" type="number" min="1" max="5" />
    <form:errors path="rating" cssClass="error" /><br/><br/>

    <label for="comment">Bình luận:</label><br/>
    <form:textarea path="comment" id="comment" rows="4" cols="50" maxlength="200" />
    <form:errors path="comment" cssClass="error" /><br/><br/>

    <input type="submit" value="Gửi đánh giá" />

</form:form>

<style>
    .error {
        color: red;
    }
</style>

</body>
</html>

