<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <p class="alert alert-danger">Subject name is ${subject.name}</p>
    Subject teachers :
    <c:forEach items="${subject.teachers}" var="teacher">
        ${teacher.name}
    </c:forEach>
</div>