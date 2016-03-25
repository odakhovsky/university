<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
    ${userBean.name}, <a href="/logout">logout</a>
</sec:authorize>
<sec:authorize access="isAnonymous()">
    <form method="post" action="/j_spring_security_check" style="padding: 25px">
        <div class="form-group">
            <input name="j_username" type="text" class="registration-input form-control"
                   placeholder="login" value="" placeholder="Login" id="login-name">
            <label class="login-field-icon fui-mail" for="login-name"></label>
        </div>

        <div class="form-group">
            <input name="j_password" type="password" class="registration-input form-control" value=""
                   placeholder="Password" id="login-pass">
            <label class="login-field-icon fui-lock" for="login-pass"></label>
        </div>

        <button type="submit" class="btn btn-default btn-lg btn-block">login</button>
    </form>

</sec:authorize>
