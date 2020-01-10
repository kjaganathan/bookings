<!DOCTYPE html>
<html lang="en">
<head>
	<title>New Booking</title>
	<link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
	<link href="/webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" rel="stylesheet">
	<link href="/webjars/font-awesome/5.12.0/css/all.min.css" rel="stylesheet">
	<link href="/css/custom.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<jsp:include page="navigation.jsp"/>
		<form action="${pageContext.request.contextPath}/bookings/new" method="post">
			<div class="form-group">
				<input type="text" class="form-control" id="name" name="member.name" placeholder="Member Name">
			</div>
			<div class="form-group">
				<input type="email" class="form-control" id="email" name="member.email" placeholder="Email">
			</div>
			<div class="form-group">
				<input type="tel" class="form-control" id="phone" name="member.phone" placeholder="Phone">
			</div>
			<div class="form-group">
				<input type="number" class="form-control" id="flatNo" name="member.flatNo" placeholder="Flat No">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="reason" name="reason" placeholder="Reason">
			</div>
		    <div class="input-group mb-2">
		        <div class="input-group-prepend">
		          <div class="input-group-text"><i class="fa fa-calendar"></i></div>
		        </div>
				<input type="text" class="form-control" id="bokingFrom" name="bokingFrom" placeholder="Booking From">
		    </div>
		    <div class="input-group mb-2">
		        <div class="input-group-prepend">
		          <div class="input-group-text"><i class="fa fa-calendar"></i></div>
		        </div>
				<input type="text" class="form-control" id="bookingTo" name="bookingTo" placeholder="Booking To">
		    </div>
			<button type="submit" class="btn btn-primary">Book ClubHouse</button>
		</form>
		<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
		<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		<script src="/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
		<script type="text/javascript">
			$('#bokingFrom').datepicker({
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