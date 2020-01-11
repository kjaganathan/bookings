<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="${pageContext.request.contextPath}">Club House Booking System</a>
	
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active">
				<a class="nav-link" href="${pageContext.request.contextPath}">Home <span class="sr-only">(current)</span></a>
			</li>
			<c:choose>
				<c:when test="${pageContext.request.userPrincipal.name != null}">
					<li class="nav-item">
						<a class="nav-link" href="/bookings">Bookings</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/bookings/new">New Booking</a>
					</li>
					<li class="nav-item dropdown pull-right">
					  	<form id="logoutForm" method="POST" action="${pageContext.request.contextPath}/logout">
				            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				        </form>
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> ${pageContext.request.userPrincipal.name} </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#" onclick="document.forms['logoutForm'].submit()">Logout</a>
						</div>
					</li>
				</c:when>
				<c:otherwise>
					<li class="nav-item">
						<a class="nav-link" href="/register">Register</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/login">Login</a>
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</nav>