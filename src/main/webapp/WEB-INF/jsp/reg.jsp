<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<title>Club House Booking System</title>
	<link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
	<link href="/webjars/font-awesome/5.12.0/css/all.min.css" rel="stylesheet">
	<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">  
		<jsp:include page="navigation.jsp"/>
        	<div style="padding-top: 2%;">
                <form id="signupform" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/register" method="post">
                	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div id="signupalert" style="display:none" class="alert alert-danger">
                        <p>Error:</p>
                        <span></span>
                    </div>
                     <div class="form-group">
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="name" placeholder="Name">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="phone" placeholder="Phone">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="email" placeholder="Email">
                        </div>
                    </div>
                     <div class="form-group">
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="flatNo" placeholder="Flat No">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-9">
                            <input type="password" class="form-control" name="password" placeholder="Password">
                        </div>
                    </div>
                     <div class="form-group">
                        <div class="col-md-9">
                            <input type="password" class="form-control" name="confPassword" placeholder="Confirm Password">
                        </div>
                    </div>
                    <div class="form-row form-group">
                        <div class="col-md-3">
                            <button id="btn-signup" type="submit" class="btn btn-primary"><i class="icon-hand-right"></i> Register</button>
                        </div>
                        <div class="col-md-3">
                            <button id="btn-gsignup" type="button" class="btn btn-primary"><i class="icon-facebook"></i>Sign Up with Google</button>
                        </div>
                        <div class="col-md-3">
                            <button id="btn-fbsignup" type="button" class="btn btn-primary"><i class="icon-facebook"></i>Sign Up with Facebook</button>
                        </div>                                           
                    </div>
                </form>
             </div>
        </div>
  </body>
</html>