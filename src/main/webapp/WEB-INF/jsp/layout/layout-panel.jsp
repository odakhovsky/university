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

        <div class="row header">
            <div class="col-xs-4">
                <img width="200" src="http://placehold.it/800x300">
                <span class="header-name">University</span>
            </div>
            <div class="col-xs-8">
                <div class="pull-right">
                    ${userBean.name} <a href="/logout"><i class="fa fa-sign-out"></i> </a>
                </div>
            </div>
        </div>
        <div class="row content content access-container">


            <!-- Blog Entries Column -->
            <div class="col-lg-12 well">
                <tiles:insertAttribute name="body"/>
            </div>

        </div>
        <!-- /.row -->

        <hr>

        <!-- Footer -->
        <footer>
            <tiles:insertAttribute name="footer"/>
        </footer>
    </div>
</div>
</body>
</html>