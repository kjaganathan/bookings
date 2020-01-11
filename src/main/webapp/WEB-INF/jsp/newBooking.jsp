<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<title>New Booking</title>
	<link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
	<link href="/webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" rel="stylesheet">
	<link href="/webjars/font-awesome/5.12.0/css/all.min.css" rel="stylesheet">
	<link href="/css/custom.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="navigation.jsp"/>
		<div class="bodyHight" style="padding-top: 2%;">
			<form action="${pageContext.request.contextPath}/bookings/new" method="post">
				<input type="hidden" name="member.id" value="${member.id}">
				<input type="hidden" name="member.name" value="${member.name}">
				<input type="hidden" name="member.email" value="${member.email}">
				<input type="hidden" name="member.phone" value="${member.phone}">
				<input type="hidden" name="member.flatNo" value="${member.flatNo}">
				<c:if test="userDetails == null">
					<div class="form-group">
						<input type="text" class="form-control" id="name" name="member.name" placeholder="Member Name">
					</div>
					<div class="form-group">
						<input type="email" class="form-control" id="email" name="member.email" placeholder="Email">
					</div>
					<div class="form-group">
						<input type="tel" class="form-control" id="phone" name="member.phone" placeholder="Phone">
					</div>
					<div class="input-group mb-2">
						 <div class="input-group-prepend">
				          <div class="input-group-text">
				          	<select name="member.flatNo" id="flatInitial">
				          		<option value="A">A</option>
				          		<option value="B">B</option>
				          		<option value="C">C</option>
				          		<option value="D">D</option>
				          	</select>
				          </div>
				        </div>
						<input type="number" class="form-control" id="flatNo" name="member.flatNo" placeholder="Flat No">
					</div>
				</c:if>
				<div class="form-group">
					<input type="text" class="form-control" id="reason" name="reason" placeholder="Reason">
				</div>
			    <div class="form-group input-group mb-2">
			        <div class="input-group-prepend">
			          <div class="input-group-text"><i class="fa fa-calendar"></i></div>
			        </div>
					<input type="text" class="form-control" id="bookingFrom" name="bookingFrom" placeholder="Booking From">
			    </div>
			    <div class="form-group input-group mb-2">
			        <div class="input-group-prepend">
			          <div class="input-group-text"><i class="fa fa-calendar"></i></div>
			        </div>
					<input type="text" class="form-control" id="bookingTo" name="bookingTo" placeholder="Booking To">
			    </div>
			    <div class="form-group">
					<button type="submit" class="btn btn-primary">Book ClubHouse</button>
			    </div>
			</form>
		</div>
		<script src="/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
		<script type="text/javascript">
			$('#bookingFrom').datepicker({
			    format: 'dd-mm-yyyy',
			    startDate: '-3d',
			    todayHighlight:'TRUE',
			    autoclose: true
			});
			$('#bookingTo').datepicker({
			    format: 'dd-mm-yyyy',
			    todayHighlight:'TRUE',
			    autoclose: true,
			});
		</script>
	</div>
</body>
</html>