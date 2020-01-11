<!DOCTYPE html>
<html lang="en">
<head>
	<title>Club House Booking System</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/custom.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="navigation.jsp"/>
		<h1>${message}</h1>
		<div class="card">
		  <div class="card-body">
		    Welcome to Utsav Homes club house booking system. This is slef service portal.
		    To Booking club house you need to follow procedure as follows,
		    <ul>
		    	<li>
		    		If you are first time user. Register yourself by clicking on Register button.
		    	</li>
		    	<li>
		    		If you are an existing user directly login
		    	</li>
		    	<li>
		    		If you are on login page and at any point of time you want to go home page please click back button of browser.
		    	</li>
		    	<li>
		    		Click on new booking option for new booking. once booking done it will be in pending status.
		    		you will be redirected to the your list of bookings. You can select any of the booking click on correct symbol
		    		to confirm booking.
		    	</li>
		    	<li>
		    		For any clarification please call +91-99-7077-2631
		    	</li>
		    </ul> 
		  </div>
		</div>
	</div>
</body>
</html>