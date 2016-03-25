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
            <div class="col-lg-12">
                <div class="row">
                    <img width="700" src="http://placehold.it/800x300" class="center-block">
                </div>
                <div class="row">
                    <h2 align="center">Welcome to our university</h2>
                </div>
            </div>
        </div>
        <div class="row content">

            <tiles:insertAttribute name="menu"/>

            <!-- Blog Entries Column -->
            <div class="col-lg-12">
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