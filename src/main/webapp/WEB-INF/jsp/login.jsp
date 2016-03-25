<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="row ">
    <h4 align="center">Only for Teachers and Administrators.</h4>
    <div class="col-lg-8 col-lg-offset-3">
        <form method="post" action="/j_spring_security_check" class="login-form form-inline">
            <div class="form-group">
                <input name="j_username" type="text" class="registration-input form-control"
                       placeholder="login" id="login-name">
                <label class="login-field-icon fui-mail" for="login-name"></label>
            </div>

            <div class="form-group">
                <input name="j_password" type="password" class="registration-input form-control" value=""
                       placeholder="Password" id="login-pass">
                <label class="login-field-icon fui-lock" for="login-pass"></label>
            </div>

            <button type="submit" class="btn btn-default button-sm login-button">login</button>
        </form>
    </div>
</div>
