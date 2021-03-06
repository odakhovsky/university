<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Hello</title>
    <tiles:insertAttribute name="header"/>

</head>
<body>
<div class="container">
    <div id="body">
        <!-- Page Content -->
        <div class="container">
            <div class="row">
                <tiles:insertAttribute name="login"/>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <tiles:insertAttribute name="body"/>
                </div>
            </div>
        </div>
    </div>
    <div id="footer">
        <div class="container">
            <tiles:insertAttribute name="footer"/>
        </div>
    </div>

</div>
</body>
</html>