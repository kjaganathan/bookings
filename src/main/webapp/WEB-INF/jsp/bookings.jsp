<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bookings</title>
<link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
<link href="/webjars/font-awesome/5.12.0/css/all.min.css" rel="stylesheet">
<link href="/css/custom.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="navigation.jsp"/>
		<div class="bodyHight" style="padding-top: 2%;">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>BookingId</th>
						<th>Name</th>
						<th>Mobile</th>
						<th>Reason</th>
						<th>Booking From</th>
						<th>Booking To</th>
						<th>Status</th>
						<th>Booked On</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bookings}" var="booking">
						<tr>
							<td>${booking.bookingId}</td>
							<td>${booking.member.name}</td>
							<td>${booking.member.phone}</td>
							<td>${booking.reason}</td>
							<td>
								<fmt:formatDate type="date" value="${booking.bookingFrom}" />
							</td>
							<td>
								<fmt:formatDate type="date" value="${booking.bookingTo}" />
							</td>
							<td>${booking.status}</td>
							<td>
								<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${booking.createdOn}" />
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/confirmBooking/${booking.id}"><i class="fa fa-check"></i></a> |
								<a href="${pageContext.request.contextPath}deleteBooking/${booking.id}"><i class="fa fa-trash"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>