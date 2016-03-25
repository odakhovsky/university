<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <h2 align="center"> ${subject.name}</h2>
    <p align="center"> Subject teachers :
        <c:forEach items="${subject.teachers}" var="teacher">
            ${teacher.name}
        </c:forEach>
    </p>
</div>