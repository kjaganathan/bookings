<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bookings</title>
<link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/custom.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<jsp:include page="navigation.jsp"/>
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
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bookings}" var="booking">
					<tr>
						<td>${booking.bookingId}</td>
						<td>${booking.member.name}</td>
						<td>${booking.member.phone}</td>
						<td>${booking.reason}</td>
						<td>${booking.bokingFrom}</td>
						<td>${booking.bookingTo}</td>
						<td>${booking.status}</td>
						<td>${booking.createdOn}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
		<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	</div>
</body>
</html>