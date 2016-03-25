<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<ul class="nav nav-pills nav-justified">
    <li><a href="/">Home</a></li>
    <li><a href="#">About</a></li>
    <li><a href="#">Contacts</a></li>
    <sec:authorize access="isAuthenticated()">
        <li><a href="/redirect">Panel</a></li>
    </sec:authorize>
    <sec:authorize access="isAnonymous()">
        <li><a href="/login">Login</a></li>
    </sec:authorize>
</ul>