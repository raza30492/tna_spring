<%-- 
    Document   : test
    Created on : 4 Sep, 2016, 10:44:12 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form:form action="${pageContext.servletContext.contextPath}/login/auth" method="get" modelAttribute="loginForm">
            <div class="row">
                <div class="form-group col-md-12">
                   <div class="col-md-2"></div>
                   <div class="col-md-2 align-left">
                      <label class="control-lable">Employee Id:</label>
                   </div>
                   <div class="col-md-5">
                      <form:input path="empId" cssClass="form-control" placeholder="Enter Employee Id"/>
                   </div>
                   <div class="col-md-3">
                      <form:errors path="empId" cssClass="error"/>
                   </div>
                </div>
             </div>
             <div class="row">
                <div class="form-group col-md-12">
                   <div class="col-md-2"></div>
                   <div class="col-md-2 align-left">
                      <label class="control-lable">Password:</label>
                   </div>
                   <div class="col-md-5">
                      <form:password path="password" cssClass="form-control" placeholder="********"/>
                   </div>
                   <div class="col-md-3">
                      <form:errors path="password" cssClass="error"/>
                   </div>
                </div>
             </div>
             <div class="row">
                <div class="col-md-12">
                   <input type="submit" value="Login" class="btn btn-primary" />
                </div>
             </div>
         </form:form>
    </body>
</html>
