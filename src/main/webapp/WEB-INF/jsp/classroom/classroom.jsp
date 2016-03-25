<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">

    <h2 align="center">
        Groups and subjects
    </h2>

    <table class="table table-responsive">

        <tbody>
        <th>
            Group
        </th>
        <th>Subjects</th>
        </tbody>
        <c:forEach items="${groups}" var="group">
        <tr>
            <td class="col-lg-1">
                    ${group.name}
            </td>
            <td>
                <c:forEach items="${group.subjects}" var="subject">
                    <a href="/classroom/group/${group.id}/subject/${subject.id}">${subject.name}</a>
                </c:forEach>
            </td>


            </c:forEach>
        </tr>
    </table>

</div>