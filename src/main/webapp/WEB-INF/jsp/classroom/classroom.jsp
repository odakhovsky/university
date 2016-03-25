<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <p class="alert alert-danger">hello world ${userBean.name}</p>

    Groups and subjects </br>

    <table>

    <c:forEach items="${groups}" var="group">
        <tr>
        <td>
                ${group.name}
        </td>
        <c:forEach items="${group.subjects}" var="subject">
            <td>
            <a href="/classroom/group/${group.id}/subject/${subject.id}">${subject.name}</a> </td>
        </c:forEach>
    </c:forEach>
        </tr>
    </table>

</div>